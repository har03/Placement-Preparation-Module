class Solution {
    public String longestPalindrome(String s) {
   int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1; 
        int start = 0; 
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
                start = i;
            }
        }
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1; 
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (length > maxLength) {
                        maxLength = length;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}
