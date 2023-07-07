package org.example;

import org.example.Person.BankCustomer;
import org.example.Person.BankStaff;
import org.example.Person.PoliceOfficer;
import org.example.Person.Thief;


public class Main {
    public static void main(String[] args) {
        PoliceOfficer officer = new PoliceOfficer("John", 35, 12345);
        Thief thief = new Thief("Tom", 25, "Shadow");
        BankCustomer bankCustomer = new BankCustomer("Frank", 40,"EH65D56");
        BankStaff bankStaff = new BankStaff("James",35,65656);

        officer.introduce();
        thief.introduce();
        bankStaff.introduce();
        bankCustomer.introduce();

        bankCustomer.attack(thief);
        officer.attack(thief);
//        officer.attack(thief);
//        officer.attack(thief);

        thief.attack(bankCustomer);


        officer.arrest(thief);

        System.out.println(officer.getHP());

    }
}