class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        boards = self.populate_board(0, n, [])
        final_boards = []
        if boards:
            for board in boards:
                this_board = []
                for queen in board:
                    s = '.' * n
                    this_board.append(s[:queen[1]] + 'Q' + s[queen[1] + 1:])
                final_boards.append(this_board)
        return final_boards

    def populate_board(self, row, n, board):
        final_results = []
        if row == n:
            final_results.append(board)
            return final_results

        for col in range(n):
            if not self.has_collision((row, col), board):
                res = self.populate_board(row + 1, n, board + [(row, col)])
                if res and len(res) > 0:
                    for r in res:
                        final_results.append(r)

        if len(final_results) > 0:
            return final_results

    def has_collision(self, queen, board):
        queen_row = queen[0]; queen_col = queen[1]
        for q in board:
            row = q[0]; col = q[1]
            if queen_col == col or (col - row) == (queen_col - queen_row) or (col + row) == (queen_col + queen_row):
                return True
        return False

if __name__ == '__main__':
    queens = Solution().solveNQueens(4)
    for queen in queens:
        print(queen)
