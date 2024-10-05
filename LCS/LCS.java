package LCS;

public class LCS {
    public static int LCS_DP(String X, String Y, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];  // DP table

        // Build the dp array
        for (int i = 1; i <= m; i++) {  // Notice <= to include the full length
            for (int j = 1; j <= n; j++) {  // Same here
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {  // i-1, j-1 for 0-based index
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // LCS length is in dp[m][n], store it before modifying m and n
        int lengthOfLCS = dp[m][n];

        // We have to Make LCS String 
        StringBuilder lcs = new StringBuilder();
        while (m > 0 && n > 0) {
            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                lcs.append(X.charAt(m - 1));
                m--;
                n--;
            } else if (dp[m - 1][n] > dp[m][n - 1]) {
                m--;
            } else {
                n--;
            }
        }

        // Reverse the string to get the correct order
        lcs.reverse();
        System.out.println("LCS: " + lcs.toString());  // Print the LCS string

        return lengthOfLCS;  // Return the length of LCS from dp[m][n]
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        int m = X.length();
        int n = Y.length();
        System.out.println("Length of LCS: " + LCS_DP(X, Y, m, n));  // Output should be 4
    }
}
