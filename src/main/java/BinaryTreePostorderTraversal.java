import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
 */

public class BinaryTreePostorderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> S = new ArrayDeque<>();

        // Check for empty tree
        if (root == null)
            return list;
        S.push(root);
        TreeNode prev = null;
        while (!S.isEmpty()) {
            TreeNode current = S.peek();

            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.val);
                }
                /* go up the tree from left node, if the child is right
                   push it onto stack otherwise process parent and pop
                   stack */
            } else if (current.left == prev) {
                if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.val);
                }

                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
            } else if (current.right == prev) {
                S.pop();
                list.add(current.val);
            }

            prev = current;
        }

        return list;
    }

    public static void main(String[] args) {

    }
}
