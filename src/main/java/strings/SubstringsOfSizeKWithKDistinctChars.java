package strings;

import java.io.*;
import java.util.*;

/**
 * Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabc", k = 3
 * Output: ["abc", "bca", "cab"]
 * <p>
 * Example 2:
 * <p>
 * Input: s = "abacab", k = 3
 * Output: ["bac", "cab"]
 * <p>
 * Example 3:
 * <p>
 * Input: s = "awaglknagawunagwkwagl", k = 4
 * Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
 * Explanation:
 * Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl"
 * "wagl" is repeated twice, but is included in the output once.
 * <p>
 * Constraints:
 * <p>
 * The input string consists of only lowercase English letters [a-z]
 * 0 ≤ k ≤ 26
 */

public class SubstringsOfSizeKWithKDistinctChars {
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    private static List<String> kSubstring(FastScanner in) {
        String s = in.next();
        int k = in.nextInt();
        Set<Character> window = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            for (; window.contains(s.charAt(end)); start++) {
                window.remove(s.charAt(start));
            }

            window.add(s.charAt(end));

            if (window.size() == k) {
                result.add(s.substring(start, end + 1));
                window.remove(s.charAt(start++));
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            out.println(kSubstring(in));
        }
    }
}
