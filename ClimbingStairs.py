__author__ = 'markdaniel'
class Solution(object):
    def climbStairs(self, n):
        if n == 1: return 1
        if n == 2: return 2
        dp = [0]*(n)
        dp[0] = 1
        dp[1] = 2
        for i in range(2, n):
            dp[i] = dp[i - 1] + dp[i - 2]

        return dp[-1]

if __name__ == '__main__':
    cases = int(input())
    sol = Solution()

    for i in range(cases):
        print(sol.climbStairs(int(input())))