__author__ = 'markdaniel'
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == []:
            return 0
        newIndex = 0
        numlen = len(nums)
        if numlen < 2:
            return numlen
        nums[newIndex] = nums[0]
        newIndex += 1
        x = 0
        while x < numlen:
            cur = nums[x]
            while x < numlen and nums[x] == cur:
                x += 1
            if x < numlen:
                nums[newIndex] = nums[x]
                newIndex += 1

        for x in xrange(newIndex, numlen):
            nums[x] = None
        return newIndex

if __name__ == '__main__':
    input = [1,1,1,2]
    print Solution().removeDuplicates(input)