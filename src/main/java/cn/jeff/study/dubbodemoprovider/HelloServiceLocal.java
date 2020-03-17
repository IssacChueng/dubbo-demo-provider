package cn.jeff.study.dubbodemoprovider;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service(interfaceClass = HelloService.class, path = "hello")
@Component
public class HelloServiceLocal implements HelloService {

    private HelloService helloService;

    Student student = new Student();
    {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        InputStream resourceAsStream = resourceLoader.getClassLoader()
                .getResourceAsStream("33981411395957.txt");
        BufferedReader bufferedReader =new BufferedReader( new InputStreamReader(resourceAsStream));
        String lines = bufferedReader.lines()
                .collect(Collectors.joining());
        student.setName(lines);
        Teacher teacher = new Teacher();
        teacher.setName(lines);
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
