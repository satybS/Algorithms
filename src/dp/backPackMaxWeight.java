package dp;

import java.util.Scanner;

public class backPackMaxWeight {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int goldBarsNum = in.nextInt();
        int mass = in.nextInt();

        int[] goldBars = new int[goldBarsNum + 1];
        for (int i = 1; i<=goldBarsNum; i++) {
            goldBars[i] = in.nextInt();
        }

        in.close();
        checkWeightAllowance(goldBars, goldBarsNum, mass);
    }

    public static void checkWeightAllowance(int[] goldBars, int goldBarsNum, int mass) {

        int[][] dp = new int[mass + 1][goldBarsNum + 1];
        for (int i = 1; i <= mass; i++) {
            for (int j = 1; j <=goldBarsNum; j++) {
                int previousMass = dp[i][j-1];
                int goldBar = goldBars[j];
                dp[i][j] = previousMass;
                if (goldBar <= i) {
                    int temp = Math.max(previousMass, dp[i-goldBar][j-1] + goldBar);
                    if (temp <= i) {
                        dp[i][j] = temp;
                    }
                }

            }
        }
        System.out.println(dp[mass][goldBarsNum]);

    }
}
