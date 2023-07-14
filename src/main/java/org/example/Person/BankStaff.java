package org.example.Person;

import org.example.behavior.Person;
import org.example.behavior.PersonInterface;

public class BankStaff extends Person implements PersonInterface {
    private int staffId;
    @Override
    public void introduce() {
        System.out.println("I am a "+getClass().getSimpleName()+" named " + name + ", " + age + " years old, my staff ID is: " + staffId + ".");

    }


    public BankStaff(String name, int age, int staffId) {
        super(name, age);
        this.staffId = staffId;
    }

    public BankStaff(int staffId) {
        this.staffId = staffId;
    }
}
