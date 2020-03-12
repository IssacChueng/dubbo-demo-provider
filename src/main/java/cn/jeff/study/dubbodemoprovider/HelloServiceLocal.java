package cn.jeff.study.dubbodemoprovider;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.stream.Collectors;

@Service(interfaceClass = HelloService.class)
@Component
public class HelloServiceLocal implements HelloService {

    private HelloService helloService;

    Student student = new Student();
    {
        File file = new File("/Users/jeff/Downloads/task.log");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.lines()
                    .collect(Collectors.joining());
            student.setName(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Teacher teacher = new Teacher();
        teacher.setName("你");
        student.setTeacher(teacher);
    }

    public HelloServiceLocal(HelloService helloService) {
        this.helloService = helloService;
    }

    public HelloServiceLocal() {
    }

    @Override
    public Student getStudent() {
        return this.student;
    }

    @Override
    public String getOneWord() {
        return "";
    }
}
