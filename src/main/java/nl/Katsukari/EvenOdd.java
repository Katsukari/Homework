package nl.Katsukari;

import java.util.HashMap;

public class EvenOdd {
    public static void main(String[] args) {
        int[] numbers = {42, 67, 35, 89, 24, 76, 58, 93, 7, 30, 83, 46, 13, 25, 98, 53, 17, 79, 57, 8};

        HashMap<String, Integer> count = new HashMap<>();
        count.put("even", 0);
        count.put("odd", 0);

        for (int number : numbers) {
            if (number % 2 == 0) {
                count.put("even", count.get("even") + 1);
            } else {
                count.put("odd", count.get("odd") + 1);
            }
        }
        // I put it here, but you can also put it inside the for-loop
        System.out.println(count);
    }
}