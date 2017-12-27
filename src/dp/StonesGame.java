package dp;

import java.util.Scanner;

public class StonesGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int stones = in.nextInt();
        in.close();
        System.out.println(choosePlayer(stones));
    }
    public static int choosePlayer(int stones) {
//        int[] dp = new int[stones+1];
//        dp[1] = 1;
//        if (stones < 2) {
//            return dp[stones];
//        }
//        dp[2] = 1;
//        if (stones < 3) {
//            return dp[stones];
//        }
//        dp[3] = 2;
//
//        for (int i = 4; i<=stones; i++) {
//            if (i%3 == 0) {
//                dp[i] = 1;
//                if (dp[i-1] ==1 && dp[i-2] ==1) {
//                    dp[i] = 2;
//                }
//            }
//            else if(i%3 == 1) {
//                dp[i] = 1;
//                if (dp[i-1] ==1 && dp[i-3] ==1) {
//                    dp[i] = 2;
//                }
//            }
//            else if(i%3 == 2) {
//                dp[i] = 1;
//                if (dp[i-1] ==1 && dp[i-2] ==1 && dp[i-3] == 1) {
//                    dp[i] = 2;
//                }
//            }
//        }
//        return dp[stones];
        if (stones %3 ==0) {
            return 2;
        }
        return 1;
    }
}
