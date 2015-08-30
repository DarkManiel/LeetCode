/**
 * Created by markdaniel on 8/28/15.
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode inverted = invertTree(root);
        traverse(inverted);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) { return null; }

        TreeNode node = new TreeNode(root.val);
        node.left = invertTree(root.right);
        node.right = invertTree(root.left);

        return node;
    }
    public static void traverse(TreeNode node) {
        if (node == null) { return; }

        System.out.print(node.val + " ");

        traverse(node.left);
        traverse(node.right);
    }
}
