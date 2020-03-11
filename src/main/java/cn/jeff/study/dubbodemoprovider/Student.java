package cn.jeff.study.dubbodemoprovider;

import lombok.Data;

@Data
public class Student {
    private String name;

    private Teacher teacher;
}
