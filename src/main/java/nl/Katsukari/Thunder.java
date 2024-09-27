package nl.Katsukari;

import java.util.Scanner;

public class Thunder {
    public static void main(String[] args) {
        final double speed_km = 0.343;  // Speed of sound in km 343 meter/s
        final double speed_feet = 1125.33;  // Speed of sound in feet/s

        // Loop to keep asking for seconds between lightning and thunder
        while (true) {
            String unit = askInput("In what unit do you want to calculate it? (km/feet)");

            // If unit doesn't exist, give feedback and prompt again
            if (!unit.equals("km") && !unit.equals("feet")) {
                System.out.println("Invalid unit. Choose again.\n");
                continue;
            }

            int seconds = Integer.parseInt(askInput("Enter the seconds between lightning and thunder (or type a negative number to quit): "));

            // Quit program
            if (seconds < 0) {
                System.out.println("Quitting...");
                break;
            }

            double distance;
            double speed;
            // Calculation in kilometers
            if (unit.equals("km")) {
                distance = seconds * speed_km;
                speed = speed_km;
            // Calculation in feet
            } else {
                distance = seconds * speed_feet;
                speed = speed_feet;
            }

            System.out.println("The lightning is approximately " + distance + " " + unit + " away.");
            System.out.println("The thunder is moving at a speed of " + speed + " " + unit + " per second.");
            System.out.println("It will take " + seconds + " seconds for the thunder to reach you after the lightning.\n");
        }
    }
    // Enable askInput and save input to be used
    static String askInput(String question){
        Scanner input = new Scanner(System.in);
        System.out.println(question);
        return input.next();
    }
}