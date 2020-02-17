package strings;

import java.io.*;
import java.util.*;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * <p>
 * Words in the list of banned words are given in lowercase, and free of punctuation. Words in the paragraph are not case sensitive. The answer is in lowercase.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 */

public class MostCommonWord {

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

    private static String findCommonWord(FastScanner in) throws IOException {
        String paragraph = in.reader.readLine();
        List<String> bannedWords = new ArrayList<>();
        while (true) {
            String cur = in.next();
            if ("null".equals(cur)) {
                break;
            }
            bannedWords.add(cur);
        }
        StringTokenizer tokenizer = new StringTokenizer(paragraph, " !?',;.");
        Map<String, Integer> words = new HashMap<>();
        while (tokenizer.hasMoreTokens()) {
            String cur = tokenizer.nextToken().toLowerCase();
            if (words.containsKey(cur)) {
                int value = words.get(cur);
                words.put(cur, value + 1);
            } else {
                words.putIfAbsent(cur, 1);
            }
        }
        int freq = 0;
        StringBuilder sb = new StringBuilder();
        if (bannedWords.size() == 0) {
            for (Map.Entry<String, Integer> word : words.entrySet()) {
                if (word.getValue() > freq) {
                    sb = new StringBuilder(word.getKey());
                    freq = word.getValue();
                }
            }
        } else {
            for (Map.Entry<String, Integer> word : words.entrySet()) {
                String curKey = word.getKey();
                if (!bannedWords.contains(curKey)) {
                    int curValue = word.getValue();
                    if (curValue > freq) {
                        sb = new StringBuilder(curKey);
                        freq = curValue;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            out.println(findCommonWord(in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
