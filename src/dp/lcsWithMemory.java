package dp;

import javafx.util.Pair;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class lcsWithMemory {

    private static final int THIS        = -1;
    private static final int UP          = 1;
    private static final int LEFT        = 2;
    private static final int UP_AND_LEFT = 3;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] first = new int[n+1];

        for (int i = 1; i<=n; i++) {
            first[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] second= new int[m+1];
        for (int i = 1; i<=m; i++) {
            second[i] = in.nextInt();
        }
        in.close();
        calculate(n, m, first, second);
    }

    public static void calculate(int n, int m, int[] first, int[] second) {
        int[][] dp = new int[n+1][m+1];
        int[][] paths = new int[n+1][m+1];

        if (first[1] == second[1]) {
            dp[1][1] = 1;
            paths[1][1] = THIS;
        }

        for (int i=2; i<=m; i++) {
            if (dp[1][i-1] == 1) {
                dp[1][i] = 1;
                paths[1][i] = LEFT;
            }
            else if (first[1] == second[i]) {
                dp[1][i] = 1;
                paths[1][i] = THIS;
            }
        }

        for (int i=2; i<=n; i++) {
            if (dp[i - 1][1] == 1) {
                dp[i][1] = 1;
                paths[i][1] = UP;
            }
            else if (first[i] == second[1]) {
                dp[i][1] = 1;
                paths[i][1] = THIS;
            }
        }

        for (int i = 2; i<=n; i++) {
            for (int j = 2; j<=m; j++) {
                if (dp[i-1][j] > dp[i][j-1]) {
                    dp[i][j] = dp[i-1][j];
                    paths[i][j] = UP;
                }
                else {
                    dp[i][j] = dp[i][j-1];
                    paths[i][j] = LEFT;
                }

                if (first[i] == second[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                    paths[i][j] = THIS;
                }
            }
        }
        int i = n;
        int j = m;
        LinkedList<Integer> memory = new LinkedList<>();
        while (i > 0 && j >0) {
            if (paths[i][j] == THIS) {
                memory.push(first[i]);
                i--;j--;
            }
            else if (paths[i][j] == LEFT) {
                j--;
            }
            else {
                i--;
            }
        }

        for (Integer k : memory) {
            System.out.print(k + " ");
        }

    }
}