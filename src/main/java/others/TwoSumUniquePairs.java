package others;

import java.io.*;
import java.util.*;

/**
 * Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target.
 * Return the number of pairs.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1, 1, 2, 45, 46, 46], target = 47
 * Output: 2
 * Explanation:
 * 1 + 46 = 47
 * 2 + 45 = 47
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1, 1], target = 2
 * Output: 1
 * Explanation:
 * 1 + 1 = 2
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1, 5, 1, 5], target = 6
 * Output: 1
 * Explanation:
 * [1, 5] and [5, 1] are considered the same.
 */

public class TwoSumUniquePairs {

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

    private static int findUniquePairs(FastScanner in) {
        List<Integer> arr = new ArrayList<>();
        while (true) {
            String cur = in.next();
            if ("null".equals(cur)) {
                break;
            }
            arr.add(Integer.parseInt(cur));
        }
        int target = in.nextInt();
        Set<Map.Entry<Integer, Integer>> uniquePairs = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int first = arr.get(i), second = arr.get(j);
                if (first + second == target) {
                    if (uniquePairs.contains(new AbstractMap.SimpleEntry<>(second, first))) {
                        continue;
                    }
                    Map.Entry<Integer, Integer> cur = new AbstractMap.SimpleEntry<>(first, second);
                    uniquePairs.add(cur);
                }
            }
        }
        return uniquePairs.size();
    }

    public static void main(String[] args) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            out.println(findUniquePairs(in));
        }
    }
}
