/**
 * Created by markdaniel on 8/26/15.
 */
public class UniquePathObsticles {
    public static void main(String[] args) {
        int [][] grid = {{0,0,0}, {0,0,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(grid));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length -1] == 1) { return 0; }

        for (int i = 0; i < obstacleGrid.length; i ++) {
            for (int j = 0; j < obstacleGrid[0].length; j ++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }

        // fill left Col
        boolean hitObst = false;
        for (int i = 0; i < obstacleGrid.length; i ++) {
            if (obstacleGrid[i][0] == -1) {
                hitObst = true;
            } else if (!hitObst) {
                obstacleGrid[i][0] = 1;
            }
        }

        //fill top row
        hitObst = false;
        for (int j = 0; j < obstacleGrid[0].length; j ++) {
            if (obstacleGrid[0][j] == -1) {
                hitObst = true;
            } else if (!hitObst){
                obstacleGrid[0][j] = 1;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i ++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (!(obstacleGrid[i][j] == -1)) {
                    int above = obstacleGrid[i - 1][j] == -1 ? 0 : obstacleGrid[i - 1][j];
                    int left = obstacleGrid[i][j - 1] == -1 ? 0 : obstacleGrid[i][j - 1];
                    obstacleGrid[i][j] = above + left;
                }
            }
        }

        return obstacleGrid[obstacleGrid.length -1][obstacleGrid[0].length - 1];
    }
}
