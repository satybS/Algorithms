package dp;

import java.util.Scanner;

public class LargestIncreasingSubsequenceWithMemory {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i<n; i++) {
            array[i] = in.nextInt();
        }
        in.close();
        System.out.println(calculateCommonIncreasingSubSequence(array));
    }

    public static String calculateCommonIncreasingSubSequence(int[] array) {
        int n = array.length;
        int [] dp = new int[n];
        String [] memory = new String[n];
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i< n; i++) {
            dp[i] = 1;
            memory[i] = "" + array[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] > array[j] && dp[i] <= dp[j]) {
                    int maxTemp = dp[j] + 1;
                    memory[i] = memory[j] + " " + array[i];
                    dp[i] = maxTemp;
                    if (maxTemp > max) {
                        max = maxTemp;
                        maxIndex = i;
                    }
                }
            }
        }
        return memory[maxIndex];
    }

}
