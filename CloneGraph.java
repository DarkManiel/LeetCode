import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by markdaniel on 8/26/15.
 */
public class CloneGraph {
    public static void main(String[] args) {
//        UndirectedGraphNode node1 = new UndirectedGraphNode(0);
////        UndirectedGraphNode node2 = new UndirectedGraphNode(0);
////        UndirectedGraphNode node3 = new UndirectedGraphNode(0);
//        node1.neighbors.add(node1);
//        node1.neighbors.add(node1);

//        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
//        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
//        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
//        List<UndirectedGraphNode> node1Neighbors = new ArrayList<>();
//        node1Neighbors.add(node2);
//        node1Neighbors.add(node3);
//        node1.neighbors = node1Neighbors;
//        List<UndirectedGraphNode> node2Neighbors = new ArrayList<>();
//        node2Neighbors.add(node3);
//        node2.neighbors = node2Neighbors;
//        List<UndirectedGraphNode> node3Neighbors = new ArrayList<>();
//        node3Neighbors.add(node3);
//        node3.neighbors = node3Neighbors;

//        UndirectedGraphNode dolly = cloneGraph(node1);
//
//        System.out.println(dolly);
//
//
        Scanner sc = new Scanner(System.in);


        List<List<Integer>> nodes = Arrays.asList(sc.next().split("#")).stream()
                .map(s -> Arrays.asList(s.split(",")).stream().map(i -> Integer.parseInt(i)).collect(Collectors.toList()))
                .collect(Collectors.toList());

        List<UndirectedGraphNode> nodeList = new ArrayList<>();

        for (List<Integer> node : nodes) {
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.get(0));

            nodeList.add(newNode);
        }

        for (int i = 0; i < nodes.size(); i ++) {
            List<Integer> node = nodes.get(i);
            UndirectedGraphNode nodeRep = nodeList.get(i);
            for (Integer j : node.subList(1, node.size())) {
                nodeRep.neighbors.add(nodeList.get(j));
            }
        }

        UndirectedGraphNode root = nodeList.get(0);

        cloneGraph(root);
    }


    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode newRoot = new UndirectedGraphNode(node.label);

        Map<UndirectedGraphNode, UndirectedGraphNode> nodeMapping = new HashMap<>();
        LinkedList<UndirectedGraphNode> masterQueue = new LinkedList<>();
        masterQueue.add(node);
        nodeMapping.put(node, newRoot);

        while (!masterQueue.isEmpty()) {
            UndirectedGraphNode mug = masterQueue.pop();

            for (UndirectedGraphNode neighbor : mug.neighbors) {
                if (!nodeMapping.containsKey(neighbor)) {
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    masterQueue.add(neighbor);
                    nodeMapping.get(mug).neighbors.add(newNeighbor);
                    nodeMapping.put(neighbor, newNeighbor);
                } else {
                    nodeMapping.get(mug).neighbors.add(nodeMapping.get(neighbor));
                }
            }
        }

        return newRoot;
    }
}
