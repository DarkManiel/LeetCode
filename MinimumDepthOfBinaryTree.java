import java.util.stream.Collectors;

/**
 * Created by markdaniel on 7/30/16.
 */
public class MinimumDepthOfBinaryTree {
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

        System.out.println(getMinDepth(root));
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

    public static int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int minDepth = 1;
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        current.add(root);

        while (!current.isEmpty()) {
            TreeNode node = current.pop();

            if (node.left == null && node.right == null) {
                return minDepth;
            }

            if (node.left != null) {
                next.add(node.left);
            }

            if (node.right != null) {
                next.add(node.right);
            }

            if (current.isEmpty()) {
                minDepth++;
                current = next;
                next = new LinkedList<>();
            }
        }

        return minDepth;
    }
}
