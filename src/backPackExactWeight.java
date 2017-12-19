import java.util.Scanner;

public class backPackExactWeight {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] bankNotes = new int[num];
        for (int i = 0; i<num; i++) {
            bankNotes[i] = in.nextInt();
        }
        int sum = in.nextInt();
        in.close();
        checkBankNotes(bankNotes, sum);
    }

    public static void checkBankNotes(int[] bankNotes, int sum) {
        int[] dp = new int[sum+1];

        int[] memory = new int[sum+1];
        for (int i = 0; i<sum+1; i++) {
            memory[i] = -1;
        }
        for (int i=1; i<=sum; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < bankNotes.length; j++) {
                int bankNote = bankNotes[j];
                if (i >= bankNote) {
                    if (dp[i-bankNote] + 1 < dp[i])
                    {
                        dp[i] = dp[i-bankNote] + 1;
                        memory[i] = j;
                    }
                }
            }
        }

        if (dp[sum] == Integer.MAX_VALUE) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");

    }
}
