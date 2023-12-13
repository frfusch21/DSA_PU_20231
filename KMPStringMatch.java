public class KMPStringMatch {

    public static int kmpStringMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] lps = computeLPSArray(pattern);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                return i - j;
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    private static int[] computeLPSArray(String pattern) {
        int lengthOfPattern = pattern.length();
        int[] lps = new int[lengthOfPattern];
        int length = 0;
        lps[0] = 0;
        int i = 1;

        while (i < lengthOfPattern) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        int position = kmpStringMatch(text, pattern);

        if (position == -1) {
            System.out.println("No match found");
        } else {
            System.out.println("Match found at position: " + position);
        }
    }
}
