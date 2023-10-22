package com.unibuc.lab1.ex1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.unibuc.lab1.ex1.model.Owner;
import com.unibuc.lab1.ex1.model.Pet;

@Configuration
public class ProjectConfig {

    @Bean
    public Owner owner(){
        Owner owner = new Owner();
        owner.setAge(29);
        owner.setName("Andrei");
        return owner;
    }

    @Bean
    public Pet pet(){
        Pet pet = new Pet();
        pet.setName("Pepa");
        pet.setOwner(owner());
        return pet;
    }


}
