import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by markdaniel on 8/1/16.
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cols = scanner.nextInt();
        int rows = scanner.nextInt();
        scanner.nextLine();
        List<String> lines = (Arrays.asList(scanner.next().replace("\"", "").split(",")));
        char[][] board = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = lines.get(i).charAt(j);
            }
        }

        solve(board);

        (Arrays.asList(board)).stream().forEach(x -> System.out.println(x));
    }

    public static void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) { return; }
        int rows = board.length;
        int cols = board[0].length;

        int dY[] = new int[] {0, rows - 1};
        int dX[] = new int[] {0, cols - 1};
        int dLen = 2;

        // Check top and bottom rows
        for (int i = 0; i < dLen; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (board[dY[i]][j] == 'O') {
                    bfs(board, dY[i], j);
                }
            }
        }

        // Check left and right cols
        for (int i = 0; i < dLen; i ++) {
            for (int j = 0; j < rows; j ++) {
                if (board[j][dX[i]] == 'O') {
                    bfs(board, j, dX[i]);
                }
            }
        }

        for (int i = 1; i < rows - 1; i ++) {
            for (int j = 1; j < cols - 1; j ++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'P') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void bfs(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        int[] dY = new int[]{-1, 0, 0, 1};
        int[] dX = new int[]{0, -1, 1, 0};
        int dLen = 4;
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col));

        while (!queue.isEmpty()) {
            Point point = queue.pop();

            for (int i = 0; i < dLen; i ++) {
                // Need to invoke point.x as the first arg, even though we're using that as Y = row val
                int yVal = point.x + dY[i];
                int xVal = point.y + dX[i];

                if (yVal > 0 && yVal < rows - 1 && xVal > 0 && xVal < cols - 1 && board[yVal][xVal] == 'O') {
                    board[yVal][xVal] = 'P'; // Insert P as placeholder for non-surrounded spot
                    queue.add(new Point(yVal, xVal));
                }
            }
        }
    }
}
