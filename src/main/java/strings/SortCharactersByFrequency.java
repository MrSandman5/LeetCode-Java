package strings;

import java.io.*;
import java.util.*;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * "cccaaa"
 * <p>
 * Output:
 * "cccaaa"
 * <p>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * <p>
 * Example 3:
 * <p>
 * Input:
 * "Aabb"
 * <p>
 * Output:
 * "bbAa"
 * <p>
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */

public class SortCharactersByFrequency {

    private static String frequencySort(String s) {
        Map<Character, Integer> beg = new HashMap<>();
        for (char elem : s.toCharArray()) {
            int count = beg.getOrDefault(elem, 0);
            beg.put(elem, count + 1);
        }
        Map<Character, Integer> freq = sortByValue(beg);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int count = entry.getValue();
            sb.append(String.valueOf(entry.getKey()).repeat(Math.max(0, count)));
        }
        return sb.toString();
    }

    private static Map<Character, Integer> sortByValue(Map<Character, Integer> unsortMap) {
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(unsortMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
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
            out.println(frequencySort(in.next()));
        }
    }
}
