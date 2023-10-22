package com.unibuc.lab1.ex3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.unibuc.lab1.ex3.config.ProjectConfig;
import com.unibuc.lab1.ex3.model.Pet;


public class Laborator1Application {

	public static void main(String[] args) {


		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

		Pet pet = context.getBean("pet1",Pet.class);

		System.out.println(pet);
	}
}
