import java.util.Arrays;

public class BoyerMooreStringMatch {

    static final int ALPHABET_SIZE = 256;

    private static void badCharHeuristic(char[] str, int size, int badChar[]) {
        Arrays.fill(badChar, -1);

        for (int i = 0; i < size; i++) {
            badChar[(int) str[i]] = i;
        }
    }

    private static void goodSuffixHeuristic(char[] pat, int[] goodSuffix) {
        int m = pat.length;
        int[] borderPos = new int[m + 1];
        int[] shift = new int[m + 1];

        Arrays.fill(shift, -1);

        int i = m, j = m + 1;
        borderPos[i] = j;

        while (i > 0) {
            while (j <= m && pat[i - 1] != pat[j - 1]) {
                if (shift[j] == -1) {
                    shift[j] = j - i;
                }
                j = borderPos[j];
            }
            i--;
            j--;
            borderPos[i] = j;
        }

        j = borderPos[0];
        for (i = 0; i <= m; i++) {
            if (shift[i] == -1) {
                shift[i] = j;
            }
            if (i == j) {
                j = borderPos[j];
            }
        }

        System.arraycopy(shift, 0, goodSuffix, 0, shift.length);
    }

    public static int boyerMooreStringMatch(String text, String pattern) {
        char[] txt = text.toCharArray();
        char[] pat = pattern.toCharArray();
        int n = txt.length;
        int m = pat.length;

        int[] badChar = new int[ALPHABET_SIZE];
        int[] goodSuffix = new int[m + 1];

        badCharHeuristic(pat, m, badChar);
        goodSuffixHeuristic(pat, goodSuffix);

        int s = 0;
        while (s <= (n - m)) {
            int j = m - 1;

            while (j >= 0 && pat[j] == txt[s + j]) {
                j--;
            }

            if (j < 0) {
                return s;
            } else {
                s += Math.max(1, j - badChar[txt[s + j]]);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "ABAAABCD";
        String pattern = "ABC";

        int position = boyerMooreStringMatch(text, pattern);

        if (position == -1) {
            System.out.println("No match found");
        } else {
            System.out.println("Match found at position: " + position);
        }
    }
}
