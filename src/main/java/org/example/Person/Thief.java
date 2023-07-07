package org.example.Person;

import org.example.behavior.Person;
import org.example.behavior.PersonInterface;

public class Thief extends Person implements PersonInterface {
    private String alias;

    public Thief(String name, int age, String alias) {
        super(name, age);
        this.alias = alias;
    }

    public void introduce() {
        System.out.println("I am a "+getClass().getSimpleName()+" named " + name + ", " + age + " years old, alias: " + alias + ".");
    }

}
