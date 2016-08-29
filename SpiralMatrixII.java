/**
 * Created by markdaniel on 8/23/15.
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        int in = 3;
        int[][] grid = generateMatrix(3);
        int len = grid.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int lenSpiral = n * n;
        n = Math.abs(n);

        int[][] result = new int[n][n];
        int maxCol = n - 1;
        int minCol = 0;
        int maxRow = n - 1;
        int minRow = 0;
        int input = 1;

        while (minCol <= maxCol && minRow <= maxRow) {
            int i = minRow;
            for (int j = minCol; j <= maxCol; j++) {
                result[i][j] = input++;
                if (j == maxCol) {
                    for (i = minRow + 1; i <= maxRow; i++) {
                        result[i][j] = input++;
                    }
                }
            }

            if (minRow < maxRow) {
                i = maxRow;
                for (int j = maxCol - 1; j >= minCol; j--) {
                    result[i][j] = input++;
                    if (j == minCol) {
                        for (i = maxRow - 1; i > minRow; i--) {
                            result[i][j] = input++;
                        }
                    }
                }
            }

            maxCol--;
            minCol++;
            minRow++;
            maxRow--;
        }

        return result;
    }
}
