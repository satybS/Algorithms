import java.util.Scanner;

public class SumOnSubset {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n+1];
        int[] totalSum = new int[n+1];

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int num = in.nextInt();
            sum+=num;
            array[i] = num;
            totalSum[i] = sum;
        }
        int queries = in.nextInt();

        for (int i = 0; i < queries; i++) {
            System.out.print(getSumOnSubset(totalSum, in.nextInt(), in.nextInt()) + " ");
        }

    }

    private static int getSumOnSubset(int[] totalSum, int left, int right) {
        return totalSum[right] - totalSum[left-1];
    }

}
