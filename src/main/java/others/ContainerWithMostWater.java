package others;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * Example:
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */

public class ContainerWithMostWater {

    private int maxArea(int[] height) {
        int maxSquare = 0;
        boolean flag = false;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                if (i == j) continue;
                if (height[i] == height[j]) flag = true;
                int tmp = (i > j ? i - j : j - i) * (flag ? height[i] : (Math.min(height[i], height[j])));
                if (tmp > maxSquare) maxSquare = tmp;
                flag = false;
            }
        }
        return maxSquare;
    }

    public static void main(String[] args) {

    }

}
