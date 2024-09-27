# //Give all value that present for odd time in array of string 
# //exampe array is { c# , sql , php , php , sql , sql } then output is {c#  , sql}

def count_occurrences(arr):
    count_dict = {}  # Initialize an empty dictionary
    for val in arr:
        if val in count_dict:
            count_dict[val] += 1  # Increment if already exists
        else:
            count_dict[val] = 1  # Add new val with count 1
    return count_dict

def oddOccurrences(count_dict):
    oddCount = {}
    for key, value in count_dict.items():
        if value % 2 != 0:
            oddCount[key] = value
    return oddCount


arr = ["c#", "sql", "php", "php", "sql", "sql"]
temp = count_occurrences(arr)
result = oddOccurrences(temp)
print(result)