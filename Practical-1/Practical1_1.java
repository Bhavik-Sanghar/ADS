// write a program that counts the number of occurrences of each integer in a given array.

import java.util.HashMap;
import java.util.Map;

public class Practical1_1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5};

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        System.out.println("Occurrences of each integer:");
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
