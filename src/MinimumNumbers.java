import java.util.Scanner;

public class MinimumNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int step = in.nextInt();
        int minNumber = Integer.MAX_VALUE;
        int [] array = new int[n+1];
        for (int i = 1; i<=n; i++) {
            int num = in.nextInt();
            if (minNumber > num) {
                minNumber = num;
            }
            if (i % step == 0) {
                System.out.print(minNumber+ " ");
                minNumber = Integer.MAX_VALUE;
            }

        }
        in.close();
    }



}
