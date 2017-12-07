import java.util.LinkedList;
import java.util.Scanner;

public class LargestIncreasingSubsequenceWithMemory2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i<n; i++) {
            array[i] = in.nextInt();
        }
        in.close();
        calculateCommonIncreasingSubSequence(array);
    }

    public static void calculateCommonIncreasingSubSequence(int[] array) {
        int n = array.length;
        int [] dp = new int[n];
        int [] paths = new int[n];
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i< n; i++) {
            dp[i] = 1;
            paths[i] = -1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] > array[j] && dp[i] <= dp[j]) {
                    int temp = dp[j] + 1;
                    paths[i] = j;
                    dp[i] = temp;
                    if (temp > max) {
                        max = temp;
                        maxIndex = i;
                    }
                }
            }
        }
        int i = maxIndex;
        LinkedList<Integer> memory = new LinkedList<>();
        while (i >=  0) {
            memory.addFirst(array[i]);
            i = paths[i];
        }
        for (Integer j : memory) {
            System.out.print(j + " ");
        }

    }

}
