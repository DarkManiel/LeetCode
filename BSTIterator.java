import java.util.Stack;

/**
 * Created by markdaniel on 8/22/15.
 */
public class BSTIterator {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(3);

        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(6);
        node.left.right.left = new TreeNode(4);
        node.left.right.right = new TreeNode(7);

        node.right = new TreeNode(10);
        node.right.right = new TreeNode(14);
        node.right.right.right = new TreeNode(13);
        BSTIterator it = new BSTIterator(node);
        while (it.hasNext()) {
            it.next();
        }
    }

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        int result = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return result;
    }
}