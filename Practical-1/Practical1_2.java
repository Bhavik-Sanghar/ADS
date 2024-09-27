//Give all value that present for odd time in array of string 
//exampe array is { c# , sql , php , php , sql , sql } then output is {c#  , sql}

import java.util.HashMap;
import java.util.ArrayList;


public class Practical1_2 {

    public static void main(String[] args) {
        String[] array = {"C#", "SQL", "PHP", "PHP", "SQL", "SQL"};
        HashMap<String, Integer> countMap = new HashMap<>();

        // Step 1: Count occurrences of each string
        for (String str : array) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        // Step 2: Create a new list to store strings with odd occurrences
        ArrayList<String> result = new ArrayList<>();
        for (String str : countMap.keySet()) {
            if (countMap.get(str) % 2 != 0) {
                result.add(str);  // Only add if occurrence is odd
            }
        }

        // Step 3: Print the resulting list
        System.out.println(result);
    }
}

