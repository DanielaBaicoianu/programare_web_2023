package com.example.laborator2.ex1.model;

import static com.example.laborator2.ex1.constants.Constants.BIRD_FLIES;
import static com.example.laborator2.ex1.constants.Constants.POST_CONSTRUCT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Getter
@Setter
@ToString
public class Bird implements Pet{

    @Value("${bird.name}")
    private String name;
    @Value("${bird.color}")
    private String color;

    @Override
    public void walk() {
        System.out.println(String.format(BIRD_FLIES, this.name));
    }

    @PostConstruct
    public void postConstructMethod(){
        System.out.println(String.format(POST_CONSTRUCT, this.getClass().getSimpleName()));
    }
}
