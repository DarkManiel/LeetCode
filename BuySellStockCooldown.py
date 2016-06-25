__author__ = 'markdaniel'
class Solution(object):
    def updateBestDiff(self, i, pricesI, bestDiff, dp):
        if i > 1 and (dp[i - 2] - pricesI) >= bestDiff:
            return dp[i - 2] - pricesI
        elif (-pricesI) >= bestDiff:
            return -pricesI
        return bestDiff

    def maxProfit(self, prices):
        priceLen = len(prices)
        if priceLen == 0 or priceLen == 1:
            return 0
        elif priceLen == 2:
            return max(prices[1] - prices[0], 0)
        dp = [0] * priceLen
        bestDiff = -prices[0]

        for i in range(1, priceLen):
            dp[i] = max(dp[i - 1], prices[i] + bestDiff)
            bestDiff = self.updateBestDiff(i, prices[i], bestDiff, dp)

        return dp[priceLen - 1]

if __name__ == '__main__':
    cases = int(input())

    for c in range(cases):
        prices = [int(x) for x in input()]
        sol = Solution()
        print(sol.maxProfit(prices))