package dp.one_two_dimension;

import java.util.Arrays;
import java.util.Scanner;

public class Tickets {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] time = new int[n+1][4];
        for (int i = 1; i <= n; i++) {
            time[i][1] = in.nextInt();
            time[i][2] = in.nextInt();
            time[i][3] = in.nextInt();
        }
        in.close();
        System.out.println(calculate(n, time));
    }

    public static long calculate(int n, int[][] time) {
        long[] dp = new long[n+1];
        dp[1] = time[1][1];
        if (n == 1) {
            return dp[1];
        }
        dp[2] = Math.min(time[1][2], time[2][1] + dp[1]);
        if (n == 2) {
            return dp[2];
        }
        dp[3] = Math.min(time[1][3], time[3][1] + dp[2]);
        dp[3] = Math.min(dp[3], time[2][2] + dp[1]);
        for (int i = 4; i<=n; i++) {
            dp[i] = Math.min(time[i][1] + dp[i-1], time[i-1][2] + dp[i-2]);
            dp[i] = Math.min(dp[i], time[i-2][3] + dp[i-3]);
        }
        return dp[n];
    }
}
