package Hashing;

public class HashTest {

    public static void main(String[] args) {
        // Create a hash table of size 10
        int[] table = new int[10];
        Hash.fill_null(table);

        // Test Case 1: Insert unique keys
        System.out.println("Test Case 1: Insert unique keys");
        Hash.insert(table, 12); // Expected: Inserted at index 2
        Hash.insert(table, 25); // Expected: Inserted at index 5
        Hash.insert(table, 39); // Expected: Inserted at index 9
        Hash.insert(table, 41); // Expected: Inserted at index 1
        Hash.insert(table, 55); // Expected: Inserted at index 5 (collision)

        System.out.print("Current Table: ");
        Hash.print_table(table);

        // Test Case 2: Search for existing keys
        System.out.println("\nTest Case 2: Search for existing keys");
        Hash.search(table, 25); // Expected: Found at index 5
        Hash.search(table, 55); // Expected: Found at index 6

        // Test Case 3: Search for non-existing key
        System.out.println("\nTest Case 3: Search for non-existing key");
        Hash.search(table, 10); // Expected: Key not found

        // Test Case 4: Delete existing keys
        System.out.println("\nTest Case 4: Delete existing keys");
        Hash.delete(table, 25); // Expected: Deleted from index 5
        Hash.delete(table, 55); // Expected: Deleted from index 6

        System.out.print("Current Table after deletions: ");
        Hash.print_table(table);

        // Test Case 5: Search for deleted keys
        System.out.println("\nTest Case 5: Search for deleted keys");
        Hash.search(table, 25); // Expected: Key not found
        Hash.search(table, 55); // Expected: Key not found

        // Test Case 6: Attempt to delete a non-existing key
        System.out.println("\nTest Case 6: Attempt to delete a non-existing key");
        Hash.delete(table, 10); // Expected: Key not found

        // Test Case 7: Re-insert deleted keys
        System.out.println("\nTest Case 7: Re-insert deleted keys");
        Hash.insert(table, 25); // Expected: Inserted at index 5 (replacing deleted)
        Hash.insert(table, 55); // Expected: Inserted at index 6 (replacing deleted)

        System.out.print("Final Table after re-insertions: ");
        Hash.print_table(table);

        // Test Case 8: Attempt to insert duplicate key
        System.out.println("\nTest Case 8: Attempt to insert duplicate key");
        Hash.insert(table, 25); // Expected: Already exists at index 5

    }
}