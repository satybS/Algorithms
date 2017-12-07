import java.util.Scanner;
import java.util.TreeSet;

public class LargestIncreasingSubsequence {

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

    public static int calculateCommonIncreasingSubSequence (int[] array) {
        int[] sortedArray = getSortedArray(array);
        int n = sortedArray.length;
        int m = array.length;
        int[][] dp = new int[n][m];
        if (array[0] == sortedArray[0]) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (dp[i-1][0] == 1) {
                dp[i][0] = 1;
            }
            else if (sortedArray[i] == array[0]) {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            if (dp[0][i-1] == 1) {
                dp[0][i] = 1;
            }
            else if (sortedArray[0] == array[i]) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j<m; j++) {
                if (sortedArray[i] == array[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

                }
            }
        }
        return dp[n-1][m-1];
    }

    private static int[] getSortedArray(int[] array) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : array) {
            set.add(i);
        }
        int[] result = new int[set.size()];
        int size = set.size();
        for (int i = 0; i <size; i++) {
            result[i] = set.pollFirst();
        }
        return result;
    }
}
