package com.unibuc.lab1.ex3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.unibuc.lab1.ex3.model.Owner;
import com.unibuc.lab1.ex3.model.Pet;

@Configuration
public class ProjectConfig {

    @Bean("owner1")
    @Primary
    public Owner ownerBean(){
        Owner owner = new Owner();
        owner.setName("Elena");
        owner.setAddress("Bucuresti");
        owner.setAge(29);
        return owner;
    }

    @Bean("owner2")
    public Owner ownerBean2(){
        Owner owner = new Owner();
        owner.setName("Mihai");
        owner.setAddress("Bucuresti");
        owner.setAge(26);
        return owner;
    }

    @Bean("pet1")
    public Pet petBean(@Autowired Owner petOwner){
        Pet pet = new Pet(petOwner);
        pet.setName("Toto");
        return pet;
    }

    @Bean
    @Primary
    public Pet petBean2(@Autowired @Qualifier("owner2") Owner owner){
        Pet pet = new Pet(owner);
        pet.setName("Fredi");
        return pet;
    }
}
