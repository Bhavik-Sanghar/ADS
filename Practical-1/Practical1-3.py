#  insert and retrieve numbers from a file and then output the number of collisions for:

# Linear Probing
# Quadratic Probing

TABLE_SIZE = 10

# Initialize hash tables
hash_table_linear = [-1] * TABLE_SIZE
hash_table_quadratic = [-1] * TABLE_SIZE


def insert_linear(num):
    """Insert using linear probing and return True if collision occurs."""
    hash_val = num % TABLE_SIZE
    original_hash = hash_val
    collision = False

    while hash_table_linear[hash_val] != -1:
        collision = True
        hash_val = (hash_val + 1) % TABLE_SIZE
        if hash_val == original_hash:
            return collision  # Table is full, collision occurred

    hash_table_linear[hash_val] = num
    return collision


def insert_quadratic(num):
    """Insert using quadratic probing and return True if collision occurs."""
    hash_val = num % TABLE_SIZE
    original_hash = hash_val
    collision = False
    i = 1

    while hash_table_quadratic[hash_val] != -1:
        collision = True
        hash_val = (original_hash + i * i) % TABLE_SIZE
        i += 1
        if i > TABLE_SIZE or hash_val == original_hash:
            return collision  # Table is full, collision occurred

    hash_table_quadratic[hash_val] = num
    return collision


def main():
    # Initialize collision counts
    linear_collisions = 0
    quadratic_collisions = 0

    try:
        # Step 1: Read numbers from the file
        with open('/Users/bhavik/Downloads/numbers.txt', 'r') as file:
            for line in file:
                num = int(line.strip())
                
                # Step 2: Insert into both hash tables and count collisions
                if insert_linear(num):
                    linear_collisions += 1
                if insert_quadratic(num):
                    quadratic_collisions += 1

        # Step 3: Output the number of collisions
        print("Linear Probing Collisions:", linear_collisions)
        print("Quadratic Probing Collisions:", quadratic_collisions)

    except FileNotFoundError:
        print("File not found!")


if __name__ == "__main__":
    main()
