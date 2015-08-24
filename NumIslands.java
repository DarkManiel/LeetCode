import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by markdaniel on 8/21/15.
 */
public class NumIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.println("result is " + numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int result = 0;
        int[][] historyMap = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (historyMap[i][j] == 0 && grid[i][j] == '1') {
                    mapIsland(grid, historyMap, i, j);
                    result ++;
                }
            }
        }

        return result;
    }

    private static void mapIsland(char[][] grid, int[][] historyMap, int row, int col) {
        if (row > grid.length - 1 || row < 0 || col >= grid[0].length || col < 0) {
            return;
        } else if (historyMap[row][col] == 1 || grid[row][col] == '0') {
            return;
        }
        historyMap[row][col] = 1;
        mapIsland(grid, historyMap, row + 1, col);
        mapIsland(grid, historyMap, row - 1, col);
        mapIsland(grid, historyMap, row, col + 1);
        mapIsland(grid, historyMap, row, col - 1);
        return;
    }

    private static void printGrid(char[][] grid) {
        System.out.print("\n");
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                System.out.print(grid[i][j]);
            }
            System.out.print("\n");
        }
    }

    private static void printMap(int[][] grid) {
        System.out.print("\n");
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                System.out.print(grid[i][j]);
            }
            System.out.print("\n");
        }
    }
}
