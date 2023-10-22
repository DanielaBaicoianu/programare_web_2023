package com.unibuc.lab1.ex1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.unibuc.lab1.ex1.config.ProjectConfig;
import com.unibuc.lab1.ex1.model.Owner;
import com.unibuc.lab1.ex1.model.Pet;

public class Ex1Application {
    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println(context.getBean(Pet.class));
        System.out.println(context.getBean(Owner.class));

    }

}
