
import java.util.LinkedList;
import java.util.Scanner;

class  LongestCommonSubsequence {


    public static void lcs(int n, int m, int[] first, int[] second) {
        int[][] dp = new int[n+1][m +1];

        // row 0 and column 0 are initialized to 0 already

        for (int i = 1; i <n; i++)
            for (int j = 1; j <m; j++)
                if (first[i] == second[j])
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                else
                    dp[i + 1][j + 1] =
                            Math.max(dp[i + 1][j], dp[i][j + 1]);


        LinkedList<Integer> sb = new LinkedList<>();
        for (int x = n, y = m;
             x != 1 && y != 1; ) {
            if (dp[x][y] == dp[x - 1][y])
                x--;
            else if (dp[x][y] == dp[x][y - 1])
                y--;
            else {
                if (first[x - 1] == second[y-1]) {
                    sb.push(first[x - 1]);
                    x--;
                    y--;
                }

            }
        }
        for (Integer k : sb) {
            System.out.print(k + " ");
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] first = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            first[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] second = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            second[i] = in.nextInt();
        }
        in.close();
        lcs(n, m, first, second);
    }
}