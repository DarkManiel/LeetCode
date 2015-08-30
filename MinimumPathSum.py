__author__ = 'markdaniel'
class MinimumPathSum(object):
    def minPathSum(self, grid):
        sum = 0
        if len(grid) == 0:
            return sum
        if len(grid) == 1:
            for i in xrange(0, len(grid[0])):
                sum += grid[0][i]
            return sum
        if len(grid[0]) == 1:
            for i in xrange(0, len(grid)):
                sum += grid[i][0]
            return sum
        # fill out sum for leftmost
        for i in xrange(1, len(grid)):
            grid[i][0] += grid[i - 1][0]

        # fill out sum for topmost
        for i in xrange(1, len(grid[0])):
            grid[0][i] += grid[0][i - 1]
        for i in xrange(1, len(grid)):
            for j in xrange(1, len(grid[0])):
                grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])

        return grid[len(grid) - 1][len(grid[0]) - 1]


if __name__ == '__main__':
    grid = [[1,2,3],[4,5,6],[7,8,9]]
    res = MinimumPathSum().minPathSum(grid)
    print res