package nl.Katsukari;

import java.util.HashMap;
import java.util.Scanner;

public class Person {
    public static void main(String[] args) {
        // Create hashmap, name key / age value
        HashMap<String, Integer> people = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Give the user the options
        while (running) {
            System.out.println("""
                Choose an option:
                1. Add a person
                2. Remove a person
                3. Show all people
                4. Exit
                Your choice:""");

            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                // Add a name to the hashmap
                case 1:
                    System.out.print("Enter name to add: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    people.put(name, age);
                    System.out.println(name + " has been added.\n");
                    break;

                // Remove a name from hashmap
                case 2:
                    System.out.print("Enter name to remove: ");
                    String nameRemove = scanner.nextLine();
                    if (people.containsKey(nameRemove)) {
                        people.remove(nameRemove);
                        System.out.println(nameRemove + " has been removed.\n");
                    } else {
                        System.out.println("Person not found.\n");
                    }
                    break;

                // Show all people in hashmap, if there's anything to show
                case 3:
                    if (people.isEmpty()) {
                        System.out.println("There are no people in the list.\n");
                    } else {
                        System.out.println("List of people: ");
                        for (String personName : people.keySet()) {
                            System.out.println("Name: " + personName + ", Age: " + people.get(personName));
                        }
                        System.out.println();
                    }
                    break;

                // Quit program if user said so
                case 4:
                    System.out.println("Quitting...");
                    running = false;
                    break;

                // if input doesn't match anything, ask again
                default:
                    System.out.println("Invalid choice. Please choose a legitimate 1.\n");
                    break;
            }
        }
        scanner.close();
    }
}
