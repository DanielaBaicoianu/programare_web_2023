package com.example.laborator2.ex1.model;


import static com.example.laborator2.ex1.constants.Constants.POST_CONSTRUCT;
import static com.example.laborator2.ex1.constants.Constants.PRE_DESTROY;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.laborator2.ex1.aspects.MarkedForLogging;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
public class Owner {

    @Value("${owner.name}")
    private String name;

    @Autowired
    private Bird bird;


    @PostConstruct
    public void postConstructMethod(){
        System.out.println(String.format(POST_CONSTRUCT, this.getClass().getSimpleName()));
    }

    @PreDestroy
    public void preDestroyMethod(){
        System.out.println(String.format(PRE_DESTROY, this.getClass().getSimpleName()));
    }

    @MarkedForLogging
    public void markedForLoggingMethod(){
        System.out.println("This is an method annotated with markedForLoggingLogging.");
    }
}
