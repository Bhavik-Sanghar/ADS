import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Practical1_3 {
    private static final int TABLE_SIZE = 10;  // Example hash table size
    private static int[] hashTableLinear = new int[TABLE_SIZE];
    private static int[] hashTableQuadratic = new int[TABLE_SIZE];

    public static void main(String[] args) {
        // Initialize the hash tables
        for (int i = 0; i < TABLE_SIZE; i++) {
            hashTableLinear[i] = -1;  // -1 means empty
            hashTableQuadratic[i] = -1;
        }

        try {
            // Step 1: Read numbers from a file
            File file = new File("/Users/bhavik/Downloads/numbers.txt");
            Scanner sc = new Scanner(file);

            int linearCollisions = 0;
            int quadraticCollisions = 0;

            while (sc.hasNextInt()) {
                int num = sc.nextInt();
                
                // Step 2: Insert using linear probing
                if (!insertLinear(num)) {
                    linearCollisions++;
                }
                
                // Step 3: Insert using quadratic probing
                if (!insertQuadratic(num)) {
                    quadraticCollisions++;
                }
            }

            sc.close();
            
            // Output the number of collisions
            System.out.println("Linear Probing Collisions: " + linearCollisions);
            System.out.println("Quadratic Probing Collisions: " + quadraticCollisions);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    // Insert using linear probing
    private static boolean insertLinear(int num) {
        int hash = num % TABLE_SIZE;
        int originalHash = hash;
        boolean collision = false;

        while (hashTableLinear[hash] != -1) {
            collision = true;
            hash = (hash + 1) % TABLE_SIZE;  // Linear probing
            if (hash == originalHash) {
                return false;  // Table is full
            }
        }

        hashTableLinear[hash] = num;
        return collision;
    }

    // Insert using quadratic probing
    private static boolean insertQuadratic(int num) {
        int hash = num % TABLE_SIZE;
        int originalHash = hash;
        boolean collision = false;
        int i = 1;

        while (hashTableQuadratic[hash] != -1) {
            collision = true;
            hash = (originalHash + i * i) % TABLE_SIZE;  // Quadratic probing
            i++;
            if (i > TABLE_SIZE || hash == originalHash) {
                return false;  // Table is full or no slot available
            }
        }

        hashTableQuadratic[hash] = num;
        return collision;
    }
}
