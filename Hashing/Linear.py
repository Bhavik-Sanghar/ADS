def hash_function(key, table_size):
    return key % table_size

def insert(table, key):
    index = hash_function(key, len(table))
    
    # Linearly probe to find an empty spot
    original_index = index  # Store the original index to prevent infinite loops
    while table[index] is not None:  # While the spot is occupied
        print(f"Collision at index {index} for key {key}, probing next...")
        index = (index + 1) % len(table)  # Move to the next slot (wrap around)
        if index == original_index:  # Table is full, no empty slots
            print("Hash table is full, cannot insert more keys!")
            return
    
    # Place the key in the found empty spot
    table[index] = key
    print(f"Inserted key {key} at index {index}")

def search(table, key):
    index = hash_function(key, len(table))
    original_index = index  # Store the original index to prevent infinite loops
    
    # Linearly probe to find the key
    while table[index] is not None:
        if table[index] == key:  # Key found
            return print(f"Key {key} found at index {index}") 
        index = (index + 1) % len(table)  # Move to the next slot
        if index == original_index:  # We've come full circle, key not found
            break
    
    return print(f"Key {key} not found")  # Key not found

def delete(table, key):
    index = hash_function(key, len(table))
    original_index = index  # Store the original index to prevent infinite loops
    
    # Linearly probe to find the key
    while table[index] is not None:
        if table[index] == key:  # Key found
            print(f"Key {key} found at index {index}, marking as deleted.")
            table[index] = "DELETED"  # Mark the slot as deleted
            return
        index = (index + 1) % len(table)  # Move to the next slot
        if index == original_index:  # We've come full circle, key not found
            break
    
    print(f"Key {key} not found, cannot delete.")


# Initialize a hash table of size 10
table = [None] * 10

# Insert some keys
values = [5, 14, 25, 74, 8]
for val in values:
    insert(table, val)

# Display the final table
print("\nFinal hash table:")
print(table)

# # Search for keys
# print("\nSearch results:")
# for val in values:
#     print(f"Search for {val}: {'Found' if search(table, val) else 'Not Found'}")

search(table,25)

# Delete 25
delete(table,25)
print(table)

search(table,5)

