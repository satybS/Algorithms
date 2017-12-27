package dp;

import java.util.Scanner;

public class LevenshteinDistance {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.next();
        String second = in.next();
        in.close();
        System.out.println(calculate(first, second));
    }

    public static int calculate(String a, String b) {
        int n = a.length();
        int m = b.length();
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        int[][] dp = new int[n+1][m+1];


        for (int i = 0; i<n; i++) {
            if (first[i] == second[0]) {
                dp[i+1][1] = i;
            }
            else {
                dp[i+1][1] = dp[i][1] + 1;
            }
        }

        for (int i = 0; i<m; i++) {
            if (first[0] == second[i]) {
                dp[1][i+1] = i;
            }
            else {
                dp[1][i+1] = dp[1][i] + 1;
            }
        }

        for (int i =1; i<n; i++) {
            for (int j = 1; j<m; j++) {
                dp[i+1][j+1] = Math.min(dp[i][j+1], dp[i+1][j]);
                dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j]);
                if (first[i] != second[j]) {
                    dp[i+1][j+1]+=1;
                }
            }
        }
       return dp[n][m];
    }
}
