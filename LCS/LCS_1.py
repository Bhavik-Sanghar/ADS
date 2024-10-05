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

def lcs_recursive(X, Y, m, n):
    # Base case: if either string is empty
    if m == 0 or n == 0:
        return 0
    # If last characters match, reduce both strings
    if X[m - 1] == Y[n - 1]:
        return 1 + lcs_recursive(X, Y, m - 1, n - 1)    
    # If last characters don't match, reduce either of the strings and take the max
    else:
        return max(lcs_recursive(X, Y, m - 1, n), lcs_recursive(X, Y, m, n - 1))

def lcs_DP(X, Y):
    m = len(X)
    n = len(Y)
    # Create a table with an extra row and column
    dp = [[0 for j in range(n+1)] for i in range(m+1)]
    
    for i in range(1, m+1):
        for j in range(1, n+1):
            if X[i-1] == Y[j-1]:
                dp[i][j] = 1 + dp[i-1][j-1]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])
    
    print("DP Table:")
    for row in dp:
        print(row)
    
     # Reconstruct the LCS from the DP table
    lcs = []
    i, j = m, n
    while i > 0 and j > 0:
        if X[i - 1] == Y[j - 1]:
            lcs.append(X[i - 1])
            i -= 1
            j -= 1
        elif dp[i - 1][j] > dp[i][j - 1]:
            i -= 1
        else:
            j -= 1

    # Since we built the LCS backwards, reverse it
    lcs.reverse()
    return dp[m][n] , ''.join(lcs)


str1 = "Bhavik"
print(f"Length of str1 is {len(str1)}")
subsequences_str1 = generate_subsequences(str1)
print(f"String {str1} has the following subsequences: {subsequences_str1}")

str2 = "Sanghar"
subsequences_str2 = generate_subsequences(str2)
print(f"String {str2} has the following subsequences: {subsequences_str2}")


# print(is_subsequence(subsequences_str1[3], subsequences_str2[4]))

lcs, length = lcs_brute_force(str1, str2)
print(f"Longest Common Subsequence: '{lcs}', Length: {length}")

lengthWithRecursion = lcs_recursive(str1, str2, len(str1), len(str2))
print(f"Length with Recursion: {lengthWithRecursion}")

lengthWithDP = lcs_DP(str1, str2)
print(f"Length with DP: {lengthWithDP}")





