import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next();
        System.out.println(lengthOfLongestSubstring(word));
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] letters = s.toCharArray();
        Map<Character, Integer> indexes = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        int i = 0;
        for (; i < letters.length; i++) {
            Character letter = letters[i];
            if (indexes.containsKey(letter)) {
                Integer index = indexes.get(letter);
                if (index >= start ) {
                    if (i - start > maxLength) {
                        maxLength = i - start;
                    }
                    start = index + 1;
                }
            }
            indexes.put(letter, i);
        }
        if (i - start > maxLength) {
            return i-start;
        }
        return maxLength;

    }
}
