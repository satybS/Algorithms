package dp.one_two_dimension;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxExpensiveWayWithMemory {
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
        calculate(n, m, way);

    }

    public static void calculate(int n, int m, int[][] way) {
        int[][] dp = new int[n+1][m+1];
        char[][] steps = new char[n+1][m+1];
        for (int i  = 1; i<=n; i++) {
            dp[i][1] = way[i][1] + dp[i-1][1];
        }
        for (int j  = 1; j<=m; j++) {
            dp[1][j] = way[1][j] + dp[1][j-1];
        }
        for (int i = 1; i<=n; i++) {
            steps[i][1] = 'D';
        }
        for (int j = 1; j<=m; j++) {
            steps[1][j] = 'R';
        }
        for (int i = 2; i<=n; i++) {
            for (int j=2; j<=m; j++) {
                dp[i][j] = way[i][j];
                int temp = dp[i - 1][j];
                char step = 'D';
                if (temp <  dp[i][j-1]) {
                    temp = dp[i][j-1];
                    step = 'R';
                }
                dp[i][j] += temp;
                steps[i][j] = step;
            }
        }
        System.out.println(dp[n][m]);
        LinkedList<Character> memory = new LinkedList<>();
        int i = n;
        int j = m;
        while (true) {
            if (i == 1 && j== 1 || (i < 1 || j < 1)) {
                break;
            }
            memory.push(steps[i][j]);
            if (steps[i][j] =='D') {
                i--;
            }
            else {
                j--;
            }

        }
        Iterator<Character> iter = memory.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

    }
}
