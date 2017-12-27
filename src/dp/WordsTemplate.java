package dp;

import java.util.Scanner;


public class WordsTemplate {

    private static final char WILD_CHAR = '*';
    private static final char ONE_CHAR = '?';
    private static final String RUNDOM = "C";
    private static final String IMPOSSIBLE = "#";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.next();
        String second = in.next();
        in.close();
        System.out.println(printWord(first, second));
    }

    public static String printWord(String a, String b) {
        int n = a.length();
        int m = b.length();
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        String[][] dp = new String[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][0] = checkLetter(i, 0, first, second, "", "", "", dp);
        }

        for (int i = 0; i < m; i++) {
            dp[0][i] = checkLetter(0, i, first, second, "", "", "", dp);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = checkLetter(i, j, first, second, dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j], dp);
            }
        }

        if (dp[n - 1][m - 1].equals(IMPOSSIBLE)) {
            return "No solution!";
        }

        return dp[n - 1][m - 1];
    }
//
//    S[i] — символ «*», а T[j] — буква или символ «?». В данной ситуации выбираем наиболее короткое среди значений F(i, j−1) и F(i−1, j)
//    с дописанной к нему буквой T[j] (или любой буквой, если T[j] есть символ «?» ).

    private static String checkLetter(int i, int j, char[] first, char[] second, String previous, String left, String up, String[][] dp) {
        if (previous.equals(IMPOSSIBLE)) {
            return IMPOSSIBLE;
        }

        if (first[i] == second[j]) {
            if (first[i] == WILD_CHAR) {
                return getShortest(left, up);
            } else if (first[i] == ONE_CHAR) {
                return getShortest(left, up) + RUNDOM;
            } else {
                return previous + first[i];
            }
        } else if (first[i] != second[j]) {
            if (first[i] == WILD_CHAR || second[j] == WILD_CHAR) {
                if (first[i] == ONE_CHAR || second[j] == ONE_CHAR) {
                    return getShortest(left, up) + RUNDOM;
                } else {
                    if (first[i] != WILD_CHAR) {
                        return previous + first[i];
                    } else {
                        return previous + second[j];
                    }
                }
            } else if (first[i] == ONE_CHAR) {
                return getShortest(left, up) + second[j];

            } else if (second[j] == ONE_CHAR) {
                return getShortest(left, up) + first[i];

            } else {
                return IMPOSSIBLE;
            }
        } else {
            return IMPOSSIBLE;
        }
    }

    private static String getShortest(String a, String b) {
        if (!a.equals(IMPOSSIBLE)) {
            if (!b.equals(IMPOSSIBLE)) {
                if (a.length() < b.length()) {
                    return a;
                }
                return b;
            }
            return a;
        }
        return b;
    }
}