import java.util.Scanner;

public class MinCubeSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(minCubeMembers(num));
    }

    public static int minCubeMembers(int num) {
        int dp[] = new int [num + 8];
        int count =1;
        for (int i = 1; i <8; i++) {
            dp[i] = count++;
        }

        for (int i = 8; i<=num; i++) {
            int cbrt = (int) Math.cbrt(i);
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j<=cbrt; j++) {
                dp[i] = Math.min(dp[i-j*j*j] + 1, dp[i]);
            }
        }
        return dp[num];
    }
}
