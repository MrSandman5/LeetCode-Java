package trees;

/**
 * Invert a binary tree.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * <p>
 * Output:
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */

public class InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        doingInvertion(root);
        return root;
    }

    private void doingInvertion(TreeNode dummy) {
        if (dummy == null) return;
        TreeNode tmp = dummy.left;
        dummy.left = dummy.right;
        dummy.right = tmp;
        doingInvertion(dummy.left);
        doingInvertion(dummy.right);
    }
}
