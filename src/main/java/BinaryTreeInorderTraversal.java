import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Output: [1,3,2]
 */

public class BinaryTreeInorderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> inorderTraversal(TreeNode root) {
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
                    current = current.left;
                } else {
                    previous.right = null;
                    nodes.add(current.val);
                    current = current.right;
                }
            }
        }
        return nodes;
    }

    public static void main(String[] args) {

    }

}
