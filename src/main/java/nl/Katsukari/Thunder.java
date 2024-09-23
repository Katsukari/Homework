package nl.Katsukari;

import java.util.Scanner;

public class Thunder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double speed_km = 0.343;  // Speed of sound in km 343 meter/s
        final double speed_feet = 1125.33;  // Speed of sound in feet/s

        // Ask user for preferred unit of measurement
        System.out.print("Would you like to calculate the distance in kilometers or feet? (km/feet): ");
        String unit = scanner.next();

        // Loop to keep asking for seconds between lightning and thunder
        while (true) {
            System.out.print("Enter the seconds between lightning and thunder (or type a negative number to quit): ");
            int seconds = scanner.nextInt();

            // If input = negative number, quit program
            if (seconds < 0) {
                System.out.println("Exiting program.");
                break;
            }

            double distance;
            double speed;
            // if-else ladder depending on input
            if (unit.equals("km")) {
                distance = seconds * speed_km;
                speed = speed_km;
            } else if (unit.equals("feet")) {
                distance = seconds * speed_feet;
                speed = speed_feet;
            } else {
                System.out.println("Invalid unit. Please choose either 'km' or 'feet'.");
                continue;
            }
            // Show output and let the user know how fast it's going, when it'll reach the user and distance to user
            System.out.println("The lightning is approximately " + distance + " " + unit + " away.");
            System.out.println("The thunder is moving at a speed of " + speed + " " + unit + " per second.");
            System.out.println("It will take " + seconds + " seconds for the thunder to reach you after the lightning.");
        }
        scanner.close();
    }
}