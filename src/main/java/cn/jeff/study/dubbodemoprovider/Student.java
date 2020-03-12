package cn.jeff.study.dubbodemoprovider;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private String name;

    private Teacher teacher;
}
