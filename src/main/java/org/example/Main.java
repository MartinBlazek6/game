package org.example;

import org.example.Person.BankCustomer;
import org.example.Person.BankStaff;
import org.example.Person.PoliceOfficer;
import org.example.Person.Thief;
import org.example.behavior.Person;
import org.example.behavior.PersonInterface;

import java.util.*;
import java.util.stream.IntStream;


public class Main {

    static List<String> names = List.of("Tom", "Anne", "Bruce", "Kate", "John", "Alice", "John", "Amanda", "Josh", "Sean");

    static List<String> aliases = new ArrayList<>(List.of("Shadow", "BadBoy", "CruelBoi", "25CENT", "IceRectangle", "ANYMEN", "Good Dog"));
    static List<String> IDs = new ArrayList<>(List.of("EH95D56", "EH65D56", "EH65X56", "EF65D56", "AH65D56", "EH65D77", "EH65D56", "EH65D12", "CS65D56", "EH65D01"));
    static List<Integer> badgeNumber = new ArrayList<>(List.of(23123, 65416, 65465, 9846, 654165, 6846, 646541, 686846, 68468, 987498));
    static List<Integer> staffIds = new ArrayList<>(List.of(35735, 425242, 65786465, 982746, 786786, 2782777, 578576, 88766, 739227, 78657886));

    static List<PersonInterface> people = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.print("Enter a message: ");

        while (!input.equals("stop")) {

            System.out.print("How manny thieves you want (max = "+aliases.size()+"): ");
            input = scanner.nextLine();

            IntStream.range(0, Integer.parseInt(input)).forEach(i -> {
                int randomId = new Random().nextInt(aliases.size());
                people.add(new Thief(
                        names.get(new Random().nextInt(names.size())),
                        new Random().nextInt((40 - 20) + 1) + 20,
                        aliases.get(randomId)));
                aliases.remove(randomId);
            });
            System.out.println("You entered: " + input);

            System.out.print("How manny police officers you want (max = "+badgeNumber.size()+"): ");
            input = scanner.nextLine();
            IntStream.range(0, Integer.parseInt(input)).forEach(i -> {
                int randomId = new Random().nextInt(badgeNumber.size());
                people.add(new PoliceOfficer(
                        names.get(new Random().nextInt(names.size())),
                        new Random().nextInt((40 - 20) + 1) + 20,
                        badgeNumber.get(randomId)));
                badgeNumber.remove(randomId);
            });
            System.out.println("You entered: " + input);

            System.out.print("How manny customers you want (max = "+IDs.size()+"): ");
            input = scanner.nextLine();
            IntStream.range(0, Integer.parseInt(input)).forEach(i -> {
                int randomId = new Random().nextInt(IDs.size());
                people.add(new BankCustomer(
                        names.get(new Random().nextInt(names.size())),
                        new Random().nextInt((40 - 20) + 1) + 20,
                        IDs.get(randomId)));
                IDs.remove(randomId);
            });
            System.out.println("You entered: " + input);

            System.out.print("How manny bank staff you want (max = "+staffIds.size()+"): ");
            input = scanner.nextLine();
            IntStream.range(0, Integer.parseInt(input)).forEach(i -> {
                int randomId = new Random().nextInt(staffIds.size());
                people.add(new BankStaff(
                        names.get(new Random().nextInt(names.size())),
                        new Random().nextInt((40 - 20) + 1) + 20,
                        staffIds.get(randomId)));
                staffIds.remove(randomId);
            });
            System.out.println("You entered: " + input);
            input = "stop";
            scanner.close();

            for (PersonInterface person : people) {
                if (person instanceof Person p) {
                    p.introduce();
                }
                person.callForHelp();
            }


            Thief t1 = (Thief) people.stream().filter(p -> p.getClass().equals(Thief.class))
                    .findFirst()
                    .orElseThrow();

            PoliceOfficer p1 = (PoliceOfficer) people.stream().filter(p -> p.getClass().equals(PoliceOfficer.class))
                    .findFirst()
                    .orElseThrow();

            t1.introduce();
            p1.introduce();

            duel(t1,p1);

            Thief t2 = (Thief) people.stream().filter(p -> p.getClass().equals(Thief.class))
                    .findFirst()
                    .orElseThrow();

            duel(t2,p1);



            people.stream()
                    .filter(person -> person instanceof Person)
                    .map(person -> (Person) person)
                    .forEach(Person::introduce);


//
//            PoliceOfficer officer = new PoliceOfficer("John", 35, 12345);
//            Thief thief = new Thief("Tom", 25, "Shadow");
//            BankCustomer bankCustomer = new BankCustomer("Frank", 40, "EH65D56");
//            BankStaff bankStaff = new BankStaff("James", 35, 65656);
//
//            officer.introduce();
//            thief.introduce();
//            bankStaff.introduce();
//            bankCustomer.introduce();
//
//            bankCustomer.attack(thief);
//            officer.attack(thief);
//            officer.attack(thief);
//            officer.attack(thief);
//
//            thief.attack(bankCustomer);
//
//
//            officer.arrest(thief);
//
//            System.out.println(officer.getHP());

        }

    }
    static void duel(PersonInterface attacker, PersonInterface defender){

        while (returnInstanceOfPerson(attacker).getHP() > 0 && returnInstanceOfPerson(defender).getHP() > 0) {
            attacker.attack(defender);
            System.out.println("Police: " + returnInstanceOfPerson(defender).getHP());

            defender.attack(attacker);
            System.out.println("Thief: " + returnInstanceOfPerson(attacker).getHP());

        }
        if (returnInstanceOfPerson(attacker).getHP() >= 0 && returnInstanceOfPerson(defender).getHP() >= 0){
            people.removeAll(List.of(attacker,defender));
        }

        people.remove(returnInstanceOfPerson(defender).getHP() <= 0 ? defender : attacker);
    }

    static Person returnInstanceOfPerson(PersonInterface object){
        return object instanceof Person person ? person : null;
    }
}