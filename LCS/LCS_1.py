# Implement Longest Common Subsequence(LCS)

from itertools import combinations

def generate_subsequences(s):
    subsequences = []
    for length in range(1, len(s) + 1):
        for combo in combinations(s, length):
            subsequences.append("".join(combo))
    return subsequences


def is_subsequence(s1, s2):
    it = iter(s2)
    return all(char in it for char in s1)

def lcs_brute_force(s1, s2):
    # Generate all subsequences of s1
    subsequences_of_s1 = generate_subsequences(s1)
    
    # Variable to store the longest common subsequence
    longest_common_subsequence = ""
    
    # Check each subsequence of s1 if it's a subsequence of s2
    for subsequence in subsequences_of_s1:
        if is_subsequence(subsequence, s2):
            # Update longest subsequence if found a longer one
            if len(subsequence) > len(longest_common_subsequence):
                longest_common_subsequence = subsequence
    
    # Return the longest subsequence and its length
    return longest_common_subsequence, len(longest_common_subsequence)



str1 = "ABC"
subsequences_str1 = generate_subsequences(str1)
print(f"String {str1} has the following subsequences: {subsequences_str1}")

str2 = "ACB"
subsequences_str2 = generate_subsequences(str2)
print(f"String {str2} has the following subsequences: {subsequences_str2}")


# print(is_subsequence(subsequences_str1[3], subsequences_str2[4]))

lcs, length = lcs_brute_force(str1, str2)
print(f"Longest Common Subsequence: '{lcs}', Length: {length}")

