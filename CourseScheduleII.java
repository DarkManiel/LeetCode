import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by markdaniel on 8/7/16.
 */
public class CourseScheduleII {
    /**
     * Idea for how to do this:
     * 1. Use dualing queues to simply keep track of the levels
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pairLen = 2;
        String inputString = sc.nextLine();
        String[] input = inputString.split(", ");
        int numCourses = Integer.parseInt(input[0]);

        List<List<Integer>> preReqLists = Arrays.asList(input[1].substring(2, input[1].length() - 2).split("\\],\\[")).stream()
                .map(preReqPair -> Arrays.asList(preReqPair.split(",")).stream()
                        .map(num -> Integer.parseInt(num)).collect(Collectors.toList())).collect(Collectors.toList());

        int[][] prereqs = new int[preReqLists.size()][pairLen];

        for (int i = 0; i < preReqLists.size(); i++) {
            for (int j = 0; j < pairLen; j++) {
                prereqs[i][j] = preReqLists.get(i).get(j);
            }
        }

        int[] res = findOrder(numCourses, prereqs);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ordering = new int[numCourses];
        int lenPrereqs = prerequisites.length;
        if (lenPrereqs == 0) {
            for (int i = 0; i < numCourses; i++) {
                ordering[i] = i;
            }
            return ordering;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] preReqCounter = new int[numCourses];

        // Build the graph and preReqCounter
        for (int i = 0; i < lenPrereqs; i++) {
            int first = prerequisites[i][0];
            int second = prerequisites[i][1];
            if (graph.containsKey(second)) {
                Set<Integer> childSet = graph.get(second);
                if (!childSet.contains(first)) {
                    // Creating a counter that keeps track of where all classes with pre-reqs are at.
                    // Looking at prerequisites[x][0] because that's the class that has pre-reqs and we are logging how many different pre-reqs it has
                    preReqCounter[prerequisites[i][0]]++;
                    childSet.add(first);
                    graph.put(second, childSet);
                }
            } else {
                preReqCounter[prerequisites[i][0]]++;
                graph.put(second, new HashSet<>(Arrays.asList(first)));
            }
        }

        int orderingIndex = 0;
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (preReqCounter[i] == 0) {
                queue.add(i);
            }
        }

        int numVisited = queue.size();

        while (!queue.isEmpty()) {
            int node = queue.pop();
            ordering[orderingIndex++] = node;

            if (graph.containsKey(node)) {
                // we know node is a pre-req
                for (Integer i : graph.get(node)) {
                    // Essentially remove edge from node
                    preReqCounter[i]--;
                    // Checking if the counter is zero ensures we only move to the next element in next level that doesn't have another pre-req in the middle
                    if (preReqCounter[i] == 0) {
                        queue.add(i);
                        numVisited++;
                    }
                }
            }
        }

        // If numVisited != numCourses, we know it's not a DAG and thus impossible to return the topological ordering
        return numVisited == numCourses ? ordering : new int[0];
    }
}
