import java.util.Scanner;

public class JumpGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] array = new int[num];
        for (int i = 0; i< num; i++) {
            array[i] = in.nextInt();
        }
        in.close();
        System.out.println(canJump(array));
    }
    public static boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int maxIndex = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (maxIndex <= i && nums[i] == 0) {
                return false;
            }
            if (i + nums[i] > maxIndex) {
                maxIndex = i + nums[i];
            }
            if (maxIndex >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
