package org.example.behavior;

import org.example.Person.BankCustomer;
import org.example.Person.BankStaff;
import org.example.Person.PoliceOfficer;
import org.example.Person.Thief;


public interface PersonInterface {

    default void attack(Object object){
        System.out.println(getClass().getSimpleName() + " is attacking " + object.getClass().getSimpleName());
        switch (object.getClass().getSimpleName()) {
            case "Thief" -> ((Thief) object).setHP(((Thief) object).getHP() - 10);
            case "PoliceOfficer" -> ((PoliceOfficer) object).setHP(((PoliceOfficer) object).getHP() - 5);
            case "BankCustomer" -> ((BankCustomer) object).setHP(((BankCustomer) object).getHP() - 20);
            case "BankStaff" -> ((BankStaff) object).setHP(((BankStaff) object).getHP() - 15);
        }



    }

    default void defence(){
        System.out.println(getClass().getSimpleName() + " is defending");

    }
    default void retreat(){
        System.out.println(getClass().getSimpleName() + " is retreating");

    }
    default void callForHelp(){
        System.out.println(getClass().getSimpleName() + " is calling for help!");
    }
}
