package nl.Katsukari;

import java.util.ArrayList;
import java.util.Scanner;

public class AddingPerson {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // List to store people
        ArrayList<Person> persons = new ArrayList<>();

        // Give the user the options
        while (true) {
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
                    continue;

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
                            break;
                            // This now also goes to case 3! New feature
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
                    } break;

                // Exit program
                case "4":
                    System.out.println("Exiting...");
                    return;


                // If option doesn't exist, prompt again
                default:
                    System.out.println("Invalid option. Try again.\n");
            }
        }
    }
    // Enable the askForInput and save the input to be used
    public static String askForInput(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}