package org.example.behavior;

public abstract class Person {
    protected String name;
    protected int age;

    protected int HP;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.HP = 100;
    }
    public Person() {
    }

    public abstract void introduce();

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}
