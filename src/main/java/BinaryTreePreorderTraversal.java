import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,2,3]
 */

public class BinaryTreePreorderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        TreeNode current, previous;
        current = root;
        while (current != null) {
            if (current.left == null) {
                nodes.add(current.val);
                current = current.right;
            } else {
                previous = current.left;
                while (previous.right != null && previous.right != current)
                    previous = previous.right;
                if (previous.right == null) {
                    previous.right = current;
                    nodes.add(current.val);
                    current = current.left;
                } else {
                    previous.right = null;
                    current = current.right;
                }
            }
        }
        return nodes;
    }

    public static void main(String[] args) {

    }
}
