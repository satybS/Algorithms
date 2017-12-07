import java.util.Scanner;

public class LargestIncreasingSubsequenceOptimized {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        array[0] = in.nextInt();
        int k = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        in.close();
        for (int i = 1; i<n; i++) {
            array[i] = (k * array[i-1] + b) %m;
        }

        System.out.println(calculateCommonIncreasingSubSequence(array, n));
    }

    public static int calculateCommonIncreasingSubSequence(int[] array, int n) {
        int[] dp = new int[n+1];
        dp[0] = Integer.MIN_VALUE;
        for (int i =1; i <=n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int k: array) {
            int index = binarySearch(dp, k);
            if (k < dp[index] && k > dp[index-1]){
                dp[index] = k;
            }
        }
        int i = n;
        while (i > 0) {
            if (dp[i] !=Integer.MAX_VALUE) {
                return i;
            }
            i--;
        }
        return -1;
    }

    private static int binarySearch(int[] array, int key) {
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (key < array[mid]) {
                hi = mid - 1;
            }
            else if (key > array[mid]){
                lo = mid + 1;
            }
            else {
                return mid;
            }
        }
        return lo;
    }

}