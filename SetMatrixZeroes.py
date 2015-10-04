__author__ = 'markdaniel'
from unittest import TestCase
class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        for row in range(len(matrix)):
            for col in range(len(matrix[row])):
                if matrix[row][col] == 0:
                    # Substituting eventual 0 values with 'x'. Needed so we can keep track of original 0 vals and new 0 vals
                    for sub_col in range(len(matrix[row])):
                        if matrix[row][sub_col] is not 0:
                            matrix[row][sub_col] = 'x'
                    for sub_row in range(len(matrix)):
                        if matrix[sub_row][col] is not 0:
                            matrix[sub_row][col] = 'x'
        for row in range(len(matrix)):
            for col in range(len(matrix[row])):
                if matrix[row][col] == 'x':
                    matrix[row][col] = 0

class Tests(TestCase):
    def test1(self):
        matrix = [[0, 1, 2], [2, 4, 3], [9, 9, 9]]
        Solution().setZeroes(matrix)
        self.assertEqual(matrix, [[0, 0, 0], [0, 4, 3], [0, 9, 9]])