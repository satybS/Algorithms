package dp;

import java.util.LinkedList;
import java.util.Scanner;

public class BackPackProblemWithPrint {

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
        int [][] dp = new int [num+1][mass+1];
        for(int n=0;n<=mass;++n)
            dp[0][n]=0;

        for(int s=1;s<=num;++s)
        {
            for( int n=0;n<=mass;++n)
            {
                dp[s][n]=dp[s-1][n];
                if ( n>=weights[s] && ( dp[s-1][n-weights[s]]+values[s] > dp[s][n]) )
                    dp[s][n] = dp[s-1][n-weights[s]]+values[s];
            }
        }
        print(dp, weights, num, mass);
    }

    private static void print(int[][] dp,int[] weigths, int num, int mass) {
        if (dp[num][mass] == 0) {
            return;
        }
        else if (dp[num-1][mass] == dp[num][mass])
            print(dp, weigths,num-1,mass);
        else
        {
            print(dp, weigths, num- 1,mass-weigths[num]); // Предмет s должен обязательно
            System.out.println( num);
        }
    }
}

