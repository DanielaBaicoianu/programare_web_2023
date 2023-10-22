package com.unibuc.lab1.ex2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.unibuc.lab1.ex2.config.ProjectConfig;
import com.unibuc.lab1.ex2.model.Owner;
import com.unibuc.lab1.ex2.model.Pet;

public class Ex2Application {
    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println(context.getBean(Pet.class));
        System.out.println(context.getBean(Owner.class));

    }

}
