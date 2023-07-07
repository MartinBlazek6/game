package org.example.Person;

import org.example.behavior.Person;
import org.example.behavior.PersonInterface;

public class BankCustomer extends Person implements PersonInterface {
    private String Id;


    public BankCustomer(String name, int age, String id) {
        super(name, age);
        Id = id;
    }

    public BankCustomer(String id) {
        Id = id;
    }

    @Override
    public void introduce() {
        System.out.println("I am a " + getClass().getSimpleName() + " named " + name + ", " + age + " years old, alias: " + Id + ".");
    }
}
