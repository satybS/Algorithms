import java.util.Scanner;

public class BackPackProblem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int mass = in.nextInt();
        int[] weights = new int[num + 1];
        int[] values = new int[num + 1];

        for (int i = 1; i<=num; i++) {
            weights[i] = in.nextInt();
        }
        for (int i = 1; i<=num; i++) {
            values[i] = in.nextInt();
        }
        maxBackPackValue(num, mass, weights, values);
        in.close();
    }

    public static void maxBackPackValue(int num, int mass, int[] weights, int[] values) {
        int[][] dp = new int[mass+1][num+1];

        for (int i = 1; i <= mass; i++) {
            for (int j = 1; j <= num; j++) {
                int weight = weights[j];
                int value = values[j];
                dp[i][j] = dp[i-1][j-1];
                if (weight <= i) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-weight][j-1] + value);
                }
            }
        }
        System.out.println(dp[mass][num]);
    }
}
