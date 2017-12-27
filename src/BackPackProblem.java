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

    public static void maxBackPackValue(int k, int W, int[] w, int[] p) {
        int [][] A = new int [k+1][W+1];
        for(int n=0;n<=W;++n)
            A[0][n]=0;

        for(int s=1;s<=k;++s)
        {
            for( int n=0;n<=W;++n)
            {
                A[s][n]=A[s-1][n];
                if ( n>=w[s] && ( A[s-1][n-w[s]]+p[s] > A[s][n]) )
                    A[s][n] = A[s-1][n-w[s]]+p[s];
            }
        }
        System.out.println(A[k][W]);
    }
}
