import java.util.Scanner;

public class KnapsackProblemMinimumItems {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int mass = in.nextInt();
        int[] weights = new int[num + 1];

        for (int i = 1; i<=num; i++) {
            weights[i] = in.nextInt();
        }
        in.close();
        minBackPackItems(num, mass, weights);

    }

    public static void minBackPackItems(int n, int mass, int[] weights) {
        int [][] dpItems = new int [n+1][mass+1];
        int [][] dpMass = new int[n+1][mass+1];

        for (int i = 1; i<=mass; i++) {
            int weight = weights[1];
            if (weight<=i) {
                dpItems[1][i] = 1;
                dpMass[1][i] = weight;
            }
        }

        for(int i=2;i<=n;++i)
        {
            int weight = weights[i];
            for( int w=0;w<=mass;++w)
            {
                dpItems[i][w]=dpItems[i-1][w];
                dpMass[i][w] = dpMass[i-1][w];
                if ( w>=weight && ( dpMass[i-1][w - weight] + weight >= dpMass[i][w]) ) {
                    if (dpItems[i - 1][w - weight] + 1 <=dpItems[i][w]) {
                        dpItems[i][w] = dpItems[i - 1][w - weight] + 1;
                    }
                    dpMass[i][w] = dpMass[i-1][w-weight] + weight;
                }
            }
        }
        if (dpMass[n][mass] == mass) {
            System.out.println(dpItems[n][mass]);
            return;
        }
        System.out.println(0);
    }
}
