package org.example.Person;

import org.example.behavior.Person;
import org.example.behavior.PersonInterface;

public class PoliceOfficer extends Person implements PersonInterface {
    private int badgeNumber;

    public PoliceOfficer(String name, int age, int badgeNumber) {
        super(name, age);
        this.badgeNumber = badgeNumber;
    }

    public void introduce() {
        System.out.println("I am a "+getClass().getSimpleName()+" named " + name + ", " + age + " years old, badge No.: " + badgeNumber + ".");
    }

    public String getId() {
        return String.valueOf(badgeNumber);
    }

    public PoliceOfficer() {
        super();
    }

    public void arrest(Thief thief){
        System.out.println(getClass().getSimpleName() + " is arresting " + thief.getClass().getSimpleName());
        if (thief.getHP()<50){
            thief.introduce();
        }
        else {
            System.out.println(thief.getClass().getSimpleName() + " was too strong and attacked officer");
            setHP(getHP()-15);
        }
    }

}
