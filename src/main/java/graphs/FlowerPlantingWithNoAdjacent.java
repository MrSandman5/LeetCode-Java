package graphs;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.
 * <p>
 * paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.
 * <p>
 * Also, there is no garden that has more than 3 paths coming into or leaving it.
 * <p>
 * Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.
 * <p>
 * Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.  The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 3, paths = [[1,2],[2,3],[3,1]]
 * Output: [1,2,3]
 * <p>
 * Example 2:
 * <p>
 * Input: N = 4, paths = [[1,2],[3,4]]
 * Output: [1,2,1,2]
 * <p>
 * Example 3:
 * <p>
 * Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * Output: [1,2,3,4]
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10000
 * 0 <= paths.size <= 20000
 * No garden has 4 or more paths coming into or leaving it.
 * It is guaranteed an answer exists.
 */

public class FlowerPlantingWithNoAdjacent {

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

    public static int[] gardenNoAdj(int N, int[][] paths) {
        return null;
    }

    public static void main(String[] args) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            int n = in.nextInt();
            int[][] graph = new int[10001][2];
            for (int i = 0; i < 10001; i++) {
                int a = in.nextInt();
                if (a == 0) {
                    break;
                }
                int b = in.nextInt();
                graph[i][0] = a;
                graph[i][1] = b;
            }
            out.println(Arrays.toString(gardenNoAdj(n, graph)));
        }
    }
}
