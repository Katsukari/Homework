package nl.Katsukari;

import java.util.HashMap;
import java.util.Scanner;

public class Person {
    public static void main(String[] args) {
        // Create hashmap, name key / age value
        HashMap<String, Integer> people = new HashMap<>();
        boolean running = true;

        // Give the user the options
        while (running) {
            System.out.println("""
                Choose an option:
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

                // Add name to Hashmap
                case "1":
                    String name = askForInput("Enter name to add: ");
                    Integer age = Integer.parseInt(askForInput("Enter age: "));
                    people.put(name, age);
                    System.out.println(name + " has been added.\n");
                    break;

                // Remove name from Hashmap, if available
                case "2":
                    String nameRemove = askForInput("Enter name to remove: ");
                    if (people.containsKey(nameRemove)) {
                        people.remove(nameRemove);
                        System.out.println(nameRemove + " has been removed.\n");
                    } else {
                        System.out.println("Person not found.\n");
                    }
                    break;

                // Show names in Hashmap, if there's anything to show
                case "3":
                    if (people.isEmpty()) {
                        System.out.println("There are no people available.\n");
                    } else {
                        for (String personName : people.keySet()) {
                            System.out.println("Name: " + personName + ", Age: " + people.get(personName));
                        }
                    }
                    break;

                // Exit program
                case "4":
                    System.out.println("Exiting...");
                    running = false;
                    break;

                // If option doesn't exist, prompt again
                default:
                    System.out.println("You chose an non-existing option, choose again.\n");
                    break;
            }
        }
    }
    // Enable the askForInput and save the input to be used
    static String askForInput(String question){
        Scanner input = new Scanner(System.in);
        System.out.println(question);
        return input.next();
    }
}