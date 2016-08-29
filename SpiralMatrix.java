import java.util.ArrayList;
import java.util.List;

/**
 * Created by markdaniel on 8/23/15.
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        List<Integer> spiral = spiralOrder(matrix);
        for (int i : spiral) {
            System.out.println(i);
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int minCol = 0;
        int maxCol = matrix[0].length - 1;
        int minRow = 0;
        int maxRow = matrix.length - 1;

        while (minCol <= maxCol && minRow <= maxRow) {
            int i = minRow;
            for (int j = minCol; j <= maxCol; j++) {
                result.add(matrix[i][j]);
                if (j == maxCol) {
                    for (i = minRow + 1; i <= maxRow; i++) {
                        result.add(matrix[i][j]);
                    }
                }
            }

            i = maxRow;
            if (maxRow > minRow) {
                for (int j = maxCol - 1; j >= minCol; j--) {
                    result.add(matrix[i][j]);
                    if (j == minCol) {
                        for (i = maxRow - 1; i > minRow; i--) {
                            result.add(matrix[i][j]);
                        }
                    }
                }
            }

            minCol++;
            maxCol--;
            minRow++;
            maxRow--;
        }

        return result;
    }
}
