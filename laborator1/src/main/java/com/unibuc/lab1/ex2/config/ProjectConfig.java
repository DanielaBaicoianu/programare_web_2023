package com.unibuc.lab1.ex2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.unibuc.lab1.ex1.model.Owner;
import com.unibuc.lab1.ex1.model.Pet;

@Configuration
@ComponentScan(basePackages = "com.unibuc.lab1.ex2.model")
public class ProjectConfig {

}
