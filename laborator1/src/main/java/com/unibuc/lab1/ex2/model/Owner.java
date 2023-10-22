package com.unibuc.lab1.ex2.model;


import org.springframework.stereotype.Component;

@Component
public class Owner {

    private String name = "Pete";
    private Integer age = 34;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
