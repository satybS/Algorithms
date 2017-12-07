package dp.one_two_dimension;

import java.util.Scanner;

public class EscapeRoom {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] room = new int[n+1][m+1];
        for (int i= 1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                room[i][j] = in.nextInt();
            }
        }
        in.close();
        long answer = escapeDP(n, m, room);
        if (answer !=0) {
            System.out.println(answer);
        }
        else {
            System.out.println("Impossible");
        }
    }

    public static long escapeDP(int n, int m, int[][] room) {

        long[][] dp = new long[n+1][m+1];
        dp[1][1] = room[1][1];
        for (int i= 2; i<=n; i++) {
            if (dp[i-1][1] != 0) {
                dp[i][1] = room[i][1];
            }
        }
        for (int j= 2; j<=m; j++) {
            if (dp[1][j-1] != 0) {
                dp[1][j] = room[1][j];
            }
        }

        for (int i = 2; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                if (room[i-1][j] !=0) {
                    dp[i][j] = dp[i-1][j];
                }
                if(room[i][j-1] !=0) {
                    dp[i][j]+=dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
}
