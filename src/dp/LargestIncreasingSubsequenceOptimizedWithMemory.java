package dp;

import java.util.LinkedList;
import java.util.Scanner;

public class LargestIncreasingSubsequenceOptimizedWithMemory {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        array[0] = in.nextInt();
        int k = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        in.close();
        for (int i = 1; i < n; i++) {
            array[i] = (k * array[i - 1] + b) % m;
        }
        calculateCommonIncreasingSubSequence(array, n);
    }

    public static void calculateCommonIncreasingSubSequence(int[] array, int n) {
        int[] dp = new int[n + 1];
        int[] paths = new int[n + 1];
        int[] prev = new int[n];
        int length = Integer.MIN_VALUE;
        dp[0] = Integer.MIN_VALUE;
        paths[0] = -1;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int j = 0; j < n; j++) {
            int k = array[j];
            int index = binarySearch(dp, k);
            if (k < dp[index] && k > dp[index - 1]) {
                dp[index] = k;
                paths[index] = j;
                prev[j] = paths[index - 1];
                length = Math.max(length, index);

            }
        }
            int i = paths[length];
        LinkedList<Integer> answer = new LinkedList<>();
        while (i != -1) {
            answer.push(array[i]);
            i = prev[i];
        }
        for (Integer a: answer) {
            System.out.print(a + " ");
        }
    }

    private static int binarySearch(int[] array, int key) {
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (key < array[mid]) {
                hi = mid - 1;
            } else if (key > array[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

}
