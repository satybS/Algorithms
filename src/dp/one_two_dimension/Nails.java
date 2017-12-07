package dp.one_two_dimension;

import java.util.Arrays;
import java.util.Scanner;

public class Nails {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distance[i] = in.nextInt();
        }
        in.close();
        Arrays.sort(distance, 1, n+1);
        System.out.println(calculate(n, distance));
    }

    public static int calculate(int n, int[] distance) {
        int[]dp = new int[n+1];
        dp[2] = distance[2] - distance[1];
        dp[3] = distance[3] - distance[2] + dp[2];
        for (int i = 4; i<=n; i++) {
            dp[i] = distance[i] - distance[i-1];
            dp[i] += Math.min(dp[i-1], dp[i-2]);
        }
        return dp[n];
    }

}
