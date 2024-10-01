package nl.Katsukari;

import java.util.ArrayList;
import java.util.Scanner;

// Initiate class
class Person {
    String name;
    Integer age;
    String email;
    String city;
    String bsn;
    String phoneNumber;

    // Constructor
    public Person(String name, Integer age, String email, String city, String bsn, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.city = city;
        this.bsn = bsn;
        this.phoneNumber = phoneNumber;
    }

    // Display details if asked
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Email: " + email +
                ", City: " + city + ", BSN: " + bsn + ", Phone: " + phoneNumber;
    }
}

public class AddingPerson {
    public static void main(String[] args) {
        // List to store people
        ArrayList<Person> persons = new ArrayList<>();
        boolean running = true;

        // Give the user the options
        while (running) {
            System.out.println("""
                0. Go back to start
                1. Add a person
                2. Remove a person
                3. Show all people
                4. Exit""");

            // Ask input
            String chosenOption = askForInput("Choose an option: ");

            switch (chosenOption) {
                // Return to menu
                case "0":
                    return;

                // Add a person
                case "1":
                    String name = askForInput("Enter name: ");
                    Integer age = Integer.parseInt(askForInput("Enter age: "));
                    String email = askForInput("Enter email: ");
                    String city = askForInput("Enter city: ");
                    String bsn = askForInput("Enter BSN: ");
                    String phoneNumber = askForInput("Enter phone number: ");

                    Person person = new Person(name, age, email, city, bsn, phoneNumber);
                    // Add all information
                    persons.add(person);
                    System.out.println(name + " has been added with its information.\n");
                    break;

                // Remove a person
                case "2":
                    while (true) {
                        String nameToRemove = askForInput("Enter name to remove: ");

                        // Use lambda for cleaner code. Check if a person (p) matches input given
                        if (persons.removeIf(p -> p.name.equals(nameToRemove))) {
                            // Remove if true
                            System.out.println(nameToRemove + " has been removed.\n");
                            continue;
                        } else {
                            System.out.println("Name not found. Please try again.\n");
                        }
                    }

                // Show all people, if there's anything to show
                case "3":
                    if (persons.isEmpty()) {
                        System.out.println("No people in the list.\n");
                    } else {
                        for (Person p : persons) {
                            System.out.println(p);
                        }
                    }
                    break;

                // Exit program
                case "4":
                    running = false;
                    System.out.println("Exiting...");
                    break;

                // If option doesn't exist, prompt again
                default:
                    System.out.println("Invalid option. Try again.\n");
            }
        }
    }
    // Enable the askForInput and save the input to be used
    private static String askForInput(String question) {
        System.out.print(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}