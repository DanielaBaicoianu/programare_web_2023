package com.unibuc.lab1.ex3.model;

public class Pet {

    private String name = "Pepa";

    private Owner owner;

    public Pet(Owner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", owner=" + owner +
                '}';
    }
}
