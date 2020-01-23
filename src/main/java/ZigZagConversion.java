import java.io.*;
import java.util.StringTokenizer;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * <p>
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */

public class ZigZagConversion {

    private static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int n = s.length();
        StringBuilder result = new StringBuilder();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                result.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    result.append(s.charAt(j + cycleLen - i));
            }
        }
        /*while (tempRows > 0){
            if (tempRows == numRows || tempRows == 1){
                int diff = 2 * numRows - 2;
                int c = tempRows == numRows ? 0 : numRows - 1;
                for (int i = c; i < n; i += diff) {
                    result.append(s.charAt(i));
                }
            }
            else {
                int diff1 = 2 * tempRows - 2;
                int diff2 = 2 * (numRows + 1 - tempRows) - 2;
                int counter = 1;
                for (int i = numRows - tempRows; i < n;) {
                    result.append(s.charAt(i));
                    if (counter % 2 != 0){
                        i += diff1;
                    }
                    else {
                        i += diff2;
                    }
                    counter++;
                }
            }
            tempRows--;
        }*/
        return result.toString();
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            out.println(convert(in.next(), in.nextInt()));
        }
    }
}
