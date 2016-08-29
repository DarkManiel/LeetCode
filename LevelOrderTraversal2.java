import java.util.stream.Collectors;

/**
 * Created by markdaniel on 7/30/16.
 */
public class LevelOrderTraversal2 {
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

        System.out.println(lot(root));
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

    public static List<List<Integer>> lot(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Stack<List<Integer>> runningList = new Stack<>();

        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        List<Integer> currentLevelVals = new ArrayList<>();
        current.add(root);

        while (!current.isEmpty()) {
            TreeNode node = current.pop();

            if (node.left != null) {
                next.add(node.left);
            }

            if (node.right != null) {
                next.add(node.right);
            }

            currentLevelVals.add(node.val);
            if (current.isEmpty()) {
                runningList.add(currentLevelVals);
                currentLevelVals = new ArrayList<>();
                current = next;
                next = new LinkedList<>();
            }
        }

        while (!runningList.isEmpty()) {
            res.add(runningList.pop());
        }

        return res;
    }
}
