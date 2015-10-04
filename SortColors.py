__author__ = 'markdaniel'
from unittest import TestCase
class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        assert type(nums) is list
        numZeros = 0
        numOnes = 0
        numTwos = 0
        for num in nums:
            if num == 0:
                numZeros += 1
            elif num == 1:
                numOnes += 1
            else:
                numTwos += 1
        index = 0
        for num in range(numZeros):
            nums[index] = 0
            index += 1
        for num in range(numOnes):
            nums[index] = 1
            index += 1
        for num in range(numTwos):
            nums[index] = 2
            index += 1


class Tests(TestCase):
    def test1(self):
        colors = [0, 1, 0, 2, 1, 0]
        Solution().sortColors(colors)
        self.assertEqual(colors, [0, 0, 0, 1, 1, 2])