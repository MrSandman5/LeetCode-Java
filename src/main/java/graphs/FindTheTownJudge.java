package graphs;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * <p>
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * <p>
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * <p>
 * Example 3:
 * <p>
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * <p>
 * Example 4:
 * <p>
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * <p>
 * Example 5:
 * <p>
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 */

public class FindTheTownJudge {

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

    private static int findJudge(int N, int[][] trust) {
        Map<Integer, Integer> inTrust = new HashMap<>(N), outTrust = new HashMap<>(N);
        for (int i = 1; i <= N; i++) {
            inTrust.putIfAbsent(i, 0);
            outTrust.putIfAbsent(i, 0);
        }
        int i = 0;
        while (trust[i][0] != 0 && trust[i][1] != 0) {
            int whoTrust = trust[i][0], inWhomTrust = trust[i][1];
            int inTrustValue = inTrust.get(inWhomTrust);
            inTrust.put(inWhomTrust, ++inTrustValue);
            int outTrustValue = outTrust.get(whoTrust);
            outTrust.put(whoTrust, ++outTrustValue);
            i++;
        }
        int result = -1;
        for (int j = 1; j <= N; j++) {
            int inTrustValue = inTrust.get(j);
            int outTrustValue = outTrust.get(j);
            if (inTrustValue == N - 1 && outTrustValue == 0) {
                result = j;
                break;
            }
        }
        return result;
        /*int[] trustCount = new int[N+1];
        for(int[] trustEdge: trust){
            trustCount[trustEdge[1]]++;
        }

        boolean judgeFound = false;
        int valJudge = -1;

        for(int i = 1; i < trustCount.length; i++){
            if(trustCount[i] == N - 1){
                judgeFound = true;
                valJudge = i;
                break;
            }
        }

        if(!judgeFound){
            return -1;
        }

        for(int[] trustEdge: trust){

            if(valJudge == trustEdge[0]){
                return -1;
            }

        }
        return valJudge;
        * */

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
            out.println(findJudge(n, graph));
        }
    }
}
