package dp.one_two_dimension;

import java.util.Scanner;

public class MaxExpensiveWay {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] way = new int[n+1][m+1];
        for (int i= 1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                way[i][j] = in.nextInt();
            }
        }
        in.close();
        System.out.println(calculate(n, m, way));
    }

    public static long calculate(int n, int m, int[][] way) {
        long[][] dp = new long[n+1][m+1];
        for (int i  = 1; i<=n; i++) {
            dp[i][1] = way[i][1] + dp[i-1][1];
        }
        for (int j  = 1; j<=m; j++) {
            dp[1][j] = way[1][j] + dp[1][j-1];
        }
        for (int i = 2; i<=n; i++) {
            for (int j=2; j<=m; j++) {
                dp[i][j] = way[i][j];
                dp[i][j] += Math.max(dp[i - 1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}
