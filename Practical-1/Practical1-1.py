# write a program that counts the number of occurrences of each integer in a given array.

def count_occurrences(arr):
    count_dict = {}  # Initialize an empty dictionary
    for num in arr:
        if num in count_dict:
            count_dict[num] += 1  # Increment if already exists
        else:
            count_dict[num] = 1  # Add new number with count 1
    return count_dict


array = [2, 4, 4, 1, 2, 3, 3, 1, 3]
result = count_occurrences(array)
print(result)
