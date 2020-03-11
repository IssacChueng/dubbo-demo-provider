package cn.jeff.study.dubbodemoprovider;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service(interfaceClass = HelloService.class, application = "${dubbo.application}", local = "true")
@Component
public class HelloServiceLocal implements HelloService {

    private HelloService helloService;

    public HelloServiceLocal(HelloService helloService) {
        this.helloService = helloService;
    }

    public HelloServiceLocal() {
    }

    @Override
    public Student getStudent() {
        Student student = new Student();
        student.setName("我");
        Teacher teacher = new Teacher();
        teacher.setName("你");
        student.setTeacher(teacher);
        return student;
    }
}
