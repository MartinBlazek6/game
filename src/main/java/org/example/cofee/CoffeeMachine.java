package org.example.cofee;

import java.io.FileInputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import javazoom.jl.player.Player;
import java.io.FileInputStream;

class CoffeeMachine {
    private AtomicBoolean waterTankEmpty;

    public CoffeeMachine() {
        this.waterTankEmpty = new AtomicBoolean(false);
    }

    public void start() {
        System.out.println("Coffee machine started.");
        playSound("making coffe.mp3");
        Thread brewingServiceThread = new Thread(() -> {
            while (true) {
                if (waterTankEmpty.get()) {
                    System.out.println("Water tank is empty. Brewing service stopped.");
                    break;
                }

                System.out.println("Drinking coffee...");
                playSound("drinkCoffe.mp3");

                // Add your coffee brewing logic here

                try {
                    Thread.sleep(1000); // Simulating brewing time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        brewingServiceThread.start();
    }

    public void stop() {
        System.out.println("Coffee machine stopped.");
        waterTankEmpty.set(true);
    }

    public void refillWaterTank() {
        playSound("watterRefill.mp3");
        System.out.println("Water tank refilled.");
        waterTankEmpty.set(false);
    }

    public void brewNewBeans() {
        System.out.println("Brewing beans");
        playSound("coffeGrinder.mp3");
//        waterTankEmpty.set(false);
    }


    static void playSound(String sound){
        String filePath = "/Users/martinblazek/IdeaProjects/game/src/main/java/org/example/cofee/soundBank/"+sound;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Player player = new Player(fileInputStream);
            player.play();
        } catch (Exception e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.start();

        // Simulating water running out
        Thread.sleep(7000); // Wait for 5 seconds
        coffeeMachine.stop();

        // Simulating water refill
        Thread.sleep(2000); // Wait for 2 seconds
        coffeeMachine.refillWaterTank();

        coffeeMachine.start(); // Restart the coffee machine
        Thread.sleep(5000); // Wait for 5 seconds
        coffeeMachine.stop();

        // Simulating water refill
        Thread.sleep(2000); // Wait for 2 seconds
        coffeeMachine.refillWaterTank();

        coffeeMachine.brewNewBeans();
    }


}
