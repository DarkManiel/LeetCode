import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by markdaniel on 7/17/16.
 */
public class ZigZagLevelOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = (new ArrayList<>(Arrays.asList(sc.next().split(","))))
                .stream()
                .map(x -> x.equals("null") ? null : Integer.parseInt(x))
                .collect(Collectors.toCollection(ArrayList::new));

        if (nums.size() == 0) {
            return;
        }

        TreeNode root = new TreeNode(nums.get(0));
        buildTree(nums, root);

        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) { return new ArrayList<>(); }
        List<List<Integer>> levelOrderTree = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        Stack<TreeNode> oddLevel = new Stack<>();
        Stack<TreeNode> evenLevel = new Stack<>();
        boolean isOdd = true;

        oddLevel.add(root);

        while (!(oddLevel.isEmpty() && evenLevel.isEmpty())) {
            TreeNode node = isOdd ? oddLevel.pop() : evenLevel.pop();

            innerList.add(node.val);

            boolean leftNotNull = node.left != null;
            boolean rightNotNull = node.right != null;

            if (isOdd) {
                if (leftNotNull) {
                    evenLevel.add(node.left);
                }
                if (rightNotNull) {
                    evenLevel.add(node.right);
                }
            } else {
                if (rightNotNull) {
                    oddLevel.add(node.right);
                }
                if (leftNotNull) {
                    oddLevel.add(node.left);
                }
            }

            if ((isOdd && oddLevel.isEmpty()) || (!isOdd && evenLevel.isEmpty())) {
                levelOrderTree.add(innerList);
                innerList = new ArrayList<>();
                isOdd = !isOdd;
            }
        }

        return levelOrderTree;
    }

    public static void buildTree(List<Integer> nums, TreeNode root) {
        if (nums.size() == 1) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int addChildIndex = 1;

        while (!queue.isEmpty() && addChildIndex < nums.size() - 1) {
            TreeNode node = queue.pop();
            node.left = nums.get(addChildIndex) != null ? new TreeNode(nums.get(addChildIndex)) : null;
            node.right = nums.get(addChildIndex + 1) != null ? new TreeNode(nums.get(addChildIndex + 1)) : null;
            queue.add(node.left);
            queue.add(node.right);
            addChildIndex += 2;
        }
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
