import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by markdaniel on 8/7/16.
 */
public class BinaryTreeRHS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        rightHandSideView(root).stream().forEach(x -> System.out.println(x));
    }

    public static List<Integer> rightHandSideView(TreeNode root) {
        List<Integer> rightHandNums = new ArrayList<>();
        if (root == null) {
            return rightHandNums;
        }

        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        current.add(root);
        rightHandNums.add(root.val);

        while (!current.isEmpty()) {
            TreeNode node = current.pop();

            if (node.left != null) {
                next.add(node.left);
            }

            if (node.right != null) {
                next.add(node.right);
            }

            if (current.isEmpty() && !next.isEmpty()) {
                rightHandNums.add(next.peekLast().val);
                current = next;
                next = new LinkedList<>();
            }
        }

        return rightHandNums;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
