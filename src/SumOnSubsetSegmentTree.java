import java.util.Scanner;

public class SumOnSubsetSegmentTree {

    private static int[] array;
    private static int[] st;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        array = new int[n+1];
        st = new int[4* (n+1)];


        for (int i = 1; i <= n; i++) {
            array[i] = in.nextInt();
        }
        build(1, 0, n);
        int queries = in.nextInt();


//        for (int i = 0; i < queries; i++) {
//            System.out.print(getSumOnSubset(totalSum, in.nextInt(), in.nextInt()) + " ");
//        }
    }

    private static int getSumOnSubset(int[] totalSum, int left, int right) {
        return totalSum[right] - totalSum[left-1];
    }

    private static void build(int v, int l, int r) {
        if (l == r) {
            st[v] = array[l];
            return;
        }
        int mid = l + r / 2;
        build( 2 * v, l, mid);
        build(2 * v + 1, mid + 1, r);
        st[v] = st[2*v] + st[2*v+1];
    }

}
