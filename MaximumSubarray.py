__author__ = 'markdaniel'
class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        len_nums = len(nums)
        if len_nums == 0:
            return
        max = nums[0]; accum = 0
        for num in nums:
            accum += num
            if accum > max:
                max = accum
            # If we encounter a negative number, whatever max we have can't extend, so restart accum
            if accum < 0:
                accum = 0

        return max

if __name__ == '__main__':
    nums = [-2,1,-3,4,-1,2,1,-5,4]
    sol = Solution().maxSubArray(nums)
    print(sol)

