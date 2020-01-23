import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubstringWithoutRepeatingCharacters {

    private static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        HashSet<Character> substring = new HashSet<>();
        int start = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char ci = s.charAt(i);
            if (!substring.contains(ci)) {
                substring.add(ci);
                length = Math.max(length, i - start + 1);
            } else {
                for (int j = start; j < i; j++) {
                    char cj = s.charAt(j);
                    substring.remove(cj);
                    if (cj == ci) {
                        start = j + 1;
                        break;
                    }
                }
                substring.add(ci);
            }
        }
        return length;
    }

    private static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }
    }

    public static void main(String[] args) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            out.println(lengthOfLongestSubstring(in.next()));
        }
    }
}
