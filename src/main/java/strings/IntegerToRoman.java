package strings;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * <p>
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: "III"
 * <p>
 * Example 2:
 * <p>
 * Input: 4
 * Output: "IV"
 * <p>
 * Example 3:
 * <p>
 * Input: 9
 * Output: "IX"
 * <p>
 * Example 4:
 * <p>
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * <p>
 * Example 5:
 * <p>
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

public class IntegerToRoman {
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

    private static Map<Integer, Character> romans = Map.of(1, 'I', 5, 'V', 10, 'X', 50, 'L', 100, 'C', 500, 'D', 1000, 'M');

    private static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        int cur = num;
        int[] digits = new int[4];
        for (int i = 0; cur != 0; i++, cur /= 10) {
            digits[i] = cur % 10;
        }
        result.append(thousands(digits[3])).append(hundreds(digits[2])).append(dozens(digits[1])).append(numbers(digits[0]));
        return result.toString();
    }

    private static String thousands(int n) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            tmp.append(romans.get(1000));
        }
        return tmp.toString();
    }

    private static String hundreds(int n) {
        StringBuilder tmp = new StringBuilder();
        if (n >= 1 && n < 4) {
            for (int i = 0; i < n; i++) {
                tmp.append(romans.get(100));
            }
        } else if (n == 4) {
            tmp.append(romans.get(100)).append(romans.get(500));
        } else if (n >= 5 && n < 9) {
            tmp.append(romans.get(500));
            for (int i = 0; i < n - 5; i++) {
                tmp.append(romans.get(100));
            }
        } else if (n == 9) {
            tmp.append(romans.get(100)).append(romans.get(1000));
        }
        return tmp.toString();
    }

    private static String dozens(int n) {
        StringBuilder tmp = new StringBuilder();
        if (n >= 1 && n < 4) {
            for (int i = 0; i < n; i++) {
                tmp.append(romans.get(10));
            }
        } else if (n == 4) {
            tmp.append(romans.get(10)).append(romans.get(50));
        } else if (n >= 5 && n < 9) {
            tmp.append(romans.get(50));
            for (int i = 0; i < n - 5; i++) {
                tmp.append(romans.get(10));
            }
        } else if (n == 9) {
            tmp.append(romans.get(10)).append(romans.get(100));
        }
        return tmp.toString();
    }

    private static String numbers(int n) {
        StringBuilder tmp = new StringBuilder();
        if (n >= 1 && n < 4) {
            for (int i = 0; i < n; i++) {
                tmp.append(romans.get(1));
            }
        } else if (n == 4) {
            tmp.append(romans.get(1)).append(romans.get(5));
        } else if (n >= 5 && n < 9) {
            tmp.append(romans.get(5));
            for (int i = 0; i < n - 5; i++) {
                tmp.append(romans.get(1));
            }
        } else if (n == 9) {
            tmp.append(romans.get(1)).append(romans.get(10));
        }
        return tmp.toString();
    }

    /*    public String intToRoman(int num) {
       StringBuilder sb = new StringBuilder();

		while (num > 0) {

			if (num >= 1000) {
				sb.append("M");
				num = num - 1000;
				continue;

			} else if (num >= 900) {

				sb.append("CM");
				num = num - 900;
				continue;
			} else if (num >= 500) {

				sb.append("D");
				num = num - 500;
				continue;
			} else if (num >= 400) {

				sb.append("CD");
				num = num - 400;
				continue;
			} else

			if (num >= 100) {

				sb.append("C");
				num = num - 100;
				continue;
			} else if (num >= 90) {

				sb.append("XC");
				num = num - 90;
				continue;
			} else if (num >= 50) {

				sb.append("L");
				num = num - 50;
				continue;
			} else if (num >= 40) {

				sb.append("XL");
				num = num - 40;
				continue;
			} else if (num >= 10) {

				sb.append("X");
				num = num - 10;
				continue;
			} else if (num >= 9) {

				sb.append("IX");
				num = num - 9;
				continue;
			} else if (num >= 5) {

				sb.append("V");
				num = num - 5;
				continue;
			} else if (num >= 4) {

				sb.append("IV");
				num = num - 4;
				continue;
			} else if (num >= 1) {

				sb.append("I");
				num = num - 1;
				continue;
			}
		}

		return sb.toString();
    }
    * */

    public static void main(String[] args) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            int n = in.nextInt();
            out.println(intToRoman(n));
        }
    }
}
