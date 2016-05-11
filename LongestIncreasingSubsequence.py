__author__ = 'markdaniel'
class Solution(object):
    def lengthOfLIS(self, nums):
        len_nums = len(nums)
        if len_nums == 0: return 0
        if len_nums == 1: return 1
        if len_nums == 2: return 2 if nums[1] > nums[0] else 1
        dp = [1]*len_nums
        dp[0] = 1
        max_len = 1

        for i in range(len_nums):
            for j in range(i + 1, len_nums):
                if nums[j] > nums[i]:
                    dp[j] = max(dp[j], dp[i] + 1)
                    if dp[j] > max_len:
                        max_len = dp[j]
        return max_len
if __name__ == '__main__':
    cases = int(input())
    sol = Solution()
    nums = raw_input().split(',')
    seq = [int(x) for x in nums]

    for i in range(cases):
        print(sol.lengthOfLIS(seq))

# class Solution(object):
#     def lengthOfLIS(self, nums):
#         seq = [int(x) for x in nums.split(' ')]:
#
#
# if __name__ == '__main__':
#     cases = int(input())
#     sol = Solution()
#
#     for i in range(cases):
#         print(sol.lengthOfLIS(input()))