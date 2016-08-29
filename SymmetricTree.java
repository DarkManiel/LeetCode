import java.util.stream.Collectors;

/**
 * Created by markdaniel on 7/13/16.
 */
public class SymmetricTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = (new ArrayList<>(Arrays.asList(sc.next().split(",")))).stream().map(x -> x.equals("null") ? null : Integer.parseInt(x)).collect(Collectors.toCollection(ArrayList::new));

        if (nums.size() == 0) {
            return;
        }

        TreeNode root = new TreeNode(nums.get(0));

        buildTree(nums, root);

        System.out.println(isMirrorImage(root));
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

    public static boolean isMirrorImage(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return root.left == null && root.right == null;
        }
        int curRowSize = 1;
        int curRowIndex = 0;
        int nextRowSize = 2;
        // Setting this to 1 just for sake of having right row len for first loop iteration
        int numNotNull = 1;

        LinkedList<TreeNode> queue = new LinkedList<>();
        Stack<Integer> valStack = new Stack<>();
        Stack<Boolean> nullStack = new Stack<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();

            if (curRowIndex == curRowSize / 2) {
                nextRowSize = numNotNull * 2;
            }

            if (curRowIndex < curRowSize / 2) {
                valStack.add(node.val);
                nullStack.add(node.left != null);
                nullStack.add(node.right != null);
                // Need to keep track of row size by keeping track of num not null so we don't get off track
                numNotNull += (node.left != null ? 1 : 0) + (node.right != null ? 1 : 0);
            } else if (!valStack.isEmpty() && valStack.pop() != node.val || (!nullStack.isEmpty() && ((node.left != null) != nullStack.pop() || (node.right != null) != nullStack.pop()))) {
                // Return false if either node value stack doesn't match or if null stack of next row doesn't match.
                return false;
            }

            curRowIndex += 1;

            // Moving on to next row
            if (curRowIndex == curRowSize) {
                curRowIndex = 0;
                curRowSize = nextRowSize;
                numNotNull = 0;
            }

            if (!(node.left == null)) {
                queue.add(node.left);
            }

            if (!(node.right == null)) {
                queue.add(node.right);
            }
        }

        return true;
    }

    //  Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
