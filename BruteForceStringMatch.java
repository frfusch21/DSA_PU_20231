public class BruteForceStringMatch {

    public static int bruteForceStringMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "This is a simple example";
        String pattern = "simple";

        int position = bruteForceStringMatch(text, pattern);

        if (position == -1) {
            System.out.println("No match found");
        } else {
            System.out.println("Match found at position: " + position);
        }
    }
}
