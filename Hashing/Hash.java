package Hashing;

class Hash {

    // Print the current state of the hash table
    public static void print_table(int[] table) {
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i] + " ");
        }
        System.out.println();
    }

    // Fill the table with -1 to denote empty slots
    public static void fill_null(int[] table) {
        for (int i = 0; i < table.length; i++) {
            table[i] = -1;
        }
    }

    // Hash function to compute the index
    public static int hash_function(int key, int table_size) {
        return key % table_size;
    }

    // Insert a key into the hash table
    public static void insert(int[] table, int key) {
        int index = hash_function(key, table.length);
        int original_index = index;

        // Linear probing to find an empty or deleted spot
        while (table[index] != -1) {
            if (table[index] == key) { // Handling duplicate key insertion
                System.out.println(key + " already exists at index " + index);
                return;
            }
            if (table[index] == -2) { // Found a deleted slot
                // Insert directly in the deleted slot
                table[index] = key;
                System.out.println(key + " inserted at index " + index + " (replacing deleted entry)");
                return;
            }
            index = (index + 1) % table.length; // Move to the next index
            if (index == original_index) {
                System.out.println("Table is full");
                return;
            }
        }

        // Place the key in the found empty or deleted spot
        table[index] = key;
        System.out.println(key + " inserted at index " + index);
    }

    // Search for a key in the hash table
    public static void search(int[] table, int key) {
        int index = hash_function(key, table.length);
        int original_index = index;

        // Linear probing to search for the key
        while (table[index] != -1) { // Continue probing until an empty spot is found
            if (table[index] == key) { // Key found
                System.out.println(key + " (Key) found at index " + index);
                return;
            }
            index = (index + 1) % table.length; // Move to the next index
            if (index == original_index) { // We've come full circle, key not found
                break;
            }
        }
        System.out.println("Key not found");
    }

    // Delete a key from the hash table
    public static void delete(int[] table, int key) {
        int index = hash_function(key, table.length);
        int original_index = index;

        while (table[index] != -1) {
            if (table[index] == key) {
                table[index] = -2; // Mark as deleted
                System.out.println(key + " (Key) deleted from index " + index);
                return;
            }
            index = (index + 1) % table.length; // Move to the next index
            if (index == original_index) { // We've come full circle, key not found
                break;
            }
        }
        System.out.println("Key not found");
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] table = new int[10];
        fill_null(table);
        System.out.print("Empty Table: ");
        print_table(table);

        // Insert some keys
        insert(table, 12);
        insert(table, 25);
        insert(table, 39);
        insert(table, 41);
        insert(table, 55);

        print_table(table);

        // Search keys in table
        search(table, 25);
        search(table, 55);
        search(table, 10);

        // Delete keys in table
        delete(table, 25);
        delete(table, 55);
        delete(table, 10); // Attempting to delete a non-existing key

        print_table(table);

        // Search for deleted keys
        search(table, 25); // Should indicate that the key is not found
        search(table, 55); // Should indicate that the key is not found

        // Insert a new key that was deleted earlier
        insert(table, 25); // Should insert successfully now
        insert(table, 55); // Should insert successfully now
        print_table(table); // Display final table after re-insertion
    }
}
