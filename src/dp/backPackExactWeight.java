package dp;

import java.util.Scanner;

public class backPackExactWeight {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int goldBarsNum = in.nextInt();
        int mass = in.nextInt();
        int[] goldBars = new int[goldBarsNum + 1];
        for (int i = 1; i <= goldBarsNum; i++) {
            goldBars[i] = in.nextInt();
        }

        in.close();
        checkWeightAllowance(goldBars, goldBarsNum, mass);
    }

    public static void checkWeightAllowance(int[] goldBars, int goldBarsNum, int mass) {

        int[][] dp = new int[goldBarsNum + 1][mass + 1];

        for (int i = 1; i <= goldBarsNum; i++) {
            int goldBar = goldBars[i];

            for (int j = 1; j <= mass; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= goldBar && dp[i - 1][j - goldBar] + goldBar > dp[i][j]) {
                    dp[i][j] = dp[i - 1][j - goldBar] + goldBar;
                }

            }
        }
//        System.out.println(dp[goldBarsNum][mass]);
        if (dp[goldBarsNum][mass] == mass) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");

    }
}
