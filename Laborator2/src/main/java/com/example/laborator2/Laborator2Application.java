package com.example.laborator2;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;

import com.example.laborator2.ex1.config.ProjectConfig;
import com.example.laborator2.ex1.model.Bird;
import com.example.laborator2.ex1.model.Owner;


public class Laborator2Application {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Bird bird = context.getBean(Bird.class);
		Bird bird2 = context.getBean(Bird.class);

		System.out.println(bird == bird2 ? ConfigurableBeanFactory.SCOPE_SINGLETON : ConfigurableBeanFactory.SCOPE_PROTOTYPE);

		bird.setColor("black");

		System.out.println(bird.getColor().equals(bird2.getColor()) ? ConfigurableBeanFactory.SCOPE_SINGLETON : ConfigurableBeanFactory.SCOPE_PROTOTYPE);

		bird.walk();
		context.getBean(Owner.class).markedForLoggingMethod();
		
		context.close();
	}
}
