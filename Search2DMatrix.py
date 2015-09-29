__author__ = 'markdaniel'
from unittest import main, TestCase

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        mat_len = len(matrix)
        min_depth = 0
        max_depth = mat_len - 1
        cur_depth = mat_len / 2

        while True:
            cur_list = matrix[cur_depth]
            if cur_list[0]<= target and cur_list[len(cur_list) - 1] >= target:
                return target in cur_list
            else:
                if cur_list[0] > target:
                    # Decrease cur_depth
                    max_depth = cur_depth - 1
                    cur_depth = (cur_depth - min_depth) / 2 + min_depth
                else:
                    # Increase cur_depth
                    min_depth = cur_depth + 1
                    cur_depth = (max_depth + 1 - cur_depth) / 2 + (min_depth - 1)
            if min_depth > max_depth:
                return False

# if __name__ == '__main__':

class Tests(TestCase):
    def test1(self):
        matrix = [
            [1,   3,  5,  7],
            [10, 11, 16, 20],
            [23, 30, 34, 50]
        ]
        res = Solution().searchMatrix(matrix, 3)
        self.assertEqual(res, True)
        print("passed test 1")

    def test2(self):
        matrix = [[1], [3]]
        res = Solution().searchMatrix(matrix, 2)
        self.assertEqual(res, False)
        print("passed test 2")

    def test2(self):
        matrix = [[1],[3],[5]]
        res = Solution().searchMatrix(matrix, 4)
        self.assertEqual(res, False)
        print("passed test 2")

