import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by markdaniel on 8/28/15.
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = preorderTraversal(root);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode copy = root;
        while (copy != null) {
            queue.push(copy);
            list.add(copy.val);
            copy = copy.left;
        }
        while (queue != null && queue.size() != 0) {
            TreeNode node = queue.removeFirst();
            if (node.right != null) {
                queue.push(node.right);
                list.add(node.right.val);
                copy = node.right.left;
                while (copy != null) {
                    queue.push(copy);
                    list.add(copy.val);
                    copy = copy.left;
                }
            }
        }

        Iterator<TreeNode> it = queue.iterator();

        while (it.hasNext()) {
            list.add(it.next().val);
        }
        return list;
    }

    private static List<Integer> traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return new ArrayList<>();
        }


        traverse(root.left, list);

        traverse(root.right, list);
        list.add(root.val);
        return list;
    }
}
