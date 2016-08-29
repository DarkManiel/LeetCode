import java.util.LinkedList;

/**
 * Created by markdaniel on 8/23/16.
 */
public class NumIslandsBFS {
    private static final int[] dRow = new int[]{-1, 1, 0, 0};
    private static final int[] dCol = new int[]{0, 0, -1, 1};
    private static final int dLen = dRow.length;

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println("result is " + numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int islands = 0;
        int numRows = grid.length;
        int numCols = grid[0].length;
        boolean[][] visited = new boolean[numRows][numCols];

        LinkedList<Integer> queue = new LinkedList<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                char rootVal = grid[row][col];
                if (rootVal != '0' && !visited[row][col]) {
                    islands++;
                    queue.add(row * numCols + col);
                    visited[row][col] = true;

                    while (!queue.isEmpty()) {
                        bfs(queue, numCols, grid, visited);
                    }
                }
            }
        }

        return islands;
    }

    private static void bfs(LinkedList<Integer> queue, int numCols, char[][] grid, boolean[][] visited) {
        int offset = queue.pop();
        int nodeRow = offset / numCols;
        int nodeCol = offset % numCols;

        for (int d = 0; d < dLen; d++) {
            int maybeRow = nodeRow + dRow[d];
            int maybeCol = nodeCol + dCol[d];
            if (maybeRow < 0 || maybeRow >= grid.length || maybeCol < 0 || maybeCol >= grid[0].length) {
                continue;
            }
            char maybeLand = grid[maybeRow][maybeCol];
            if (maybeLand != '0' && !visited[maybeRow][maybeCol]) {
                queue.add(maybeRow * numCols + maybeCol);
                visited[maybeRow][maybeCol] = true;
            }
        }
    }
}
