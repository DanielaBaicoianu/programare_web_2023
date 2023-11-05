package com.example.laborator2.ex1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.example.laborator2.ex1")
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class ProjectConfig {


}
