package cn.jeff.study.dubbodemoprovider;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service(interfaceClass = HelloService.class, path = "hello")
@Component
public class HelloServiceLocal implements HelloService {

    private HelloService helloService;
    Student student = new Student();
    private String str1k;
    private String str50k;
    private String str200k;

    @PostConstruct
    public void init() {
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

        try {
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream inputStream = resourceLoader.getResource("1k.txt").getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            str1k = bufferedReader.lines()
                    .collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream inputStream = resourceLoader.getResource("50k.txt").getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            str50k = bufferedReader.lines()
                    .collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream inputStream = resourceLoader.getResource("200k.txt").getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            str200k = bufferedReader.lines()
                    .collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public String getOneWord(int i) {
        switch (i) {
            case 1:
                return str1k;
            case 2:
                return str50k;
            case 3:
                return str200k;
        }
        return "";
    }
}
