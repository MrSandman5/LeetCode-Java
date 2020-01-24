package trees;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */

public class ConvertSortedArrayToBinarySearchTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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

    private static TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }

    private static TreeNode createBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (right + left) / 2;
        TreeNode current = new TreeNode(nums[middle]);
        current.left = createBST(nums, left, middle - 1);
        current.right = createBST(nums, middle + 1, right);
        return current;
    }

    private static void preOrder(PrintWriter out, TreeNode node) {
        if (node == null) {
            return;
        }
        out.print(node.val + " ");
        preOrder(out, node.left);
        preOrder(out, node.right);
    }

    public static void main(String[] args) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            List<Integer> input = new ArrayList<>();
            while (true) {
                String tmp = in.next();
                if ("stop".equals(tmp)) {
                    break;
                }
                input.add(Integer.parseInt(tmp));
            }
            int[] arr = input.stream().mapToInt(i -> i).toArray();
            TreeNode bst = createBST(arr, 0, arr.length - 1);
            preOrder(out, bst);
        }
    }
}
