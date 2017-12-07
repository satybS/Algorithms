

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class lcs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] first = new int[n+1];

        for (int i = 1; i<=n; i++) {
            first[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] second= new int[m+1];
        for (int i = 1; i<=m; i++) {
            second[i] = in.nextInt();
        }
        in.close();
        System.out.println(calculate(n, m, first, second));
    }

    public static int calculate(int n, int m, int[] first, int[] second) {
        int[][] dp = new int[n+1][m+1];

        if (first[1] == second[1]) {
            dp[1][1] = 1;
        }

        for (int i=2; i<=m; i++) {
            if (dp[1][i-1] == 1) {
               dp[1][i] = 1;
            }
            else if (first[1] == second[i]) {
                dp[1][i] = 1;
            }
        }

        for (int i=2; i<=n; i++) {
            if (dp[i - 1][1] == 1) {
                dp[i][1] = 1;
            }
            else if (first[i] == second[1]) {
                dp[i][1] = 1;
            }
        }

        for (int i = 2; i<=n; i++) {
            for (int j = 2; j<=m; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

                if (first[i] == second[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }

        return dp[n][m];
    }
}
