package dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class UniquePaths {

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

    private static int findUniquePaths(FastScanner in) {
        int n = in.nextInt(), m = in.nextInt();

        int[][] dp = new int[n][m];
        dp[0][0] = 0;

        for (int j = 1; j < n; j++) {
            dp[j][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            out.println(findUniquePaths(in));
        }
    }
}
