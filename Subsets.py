__author__ = 'markdaniel'
class Solution(object):
    def get_as_set(self, nums, result_set):
        assert type(nums) is list
        assert type(result_set) is set
        # Rather than re-adding dups, return immediately
        if tuple(nums) in result_set:
            return
        tup = tuple(nums)
        result_set.add(tup)
        # Recursively check each for subsets by splitting up list
        for numIndex in range(len(nums)):
            newArr = nums[0:numIndex] + nums[numIndex + 1:]
            self.get_as_set(newArr, result_set)

    def subsets(self, nums):
        res = []
        result_set = set()
        self.get_as_set(nums, result_set)
        for tup in result_set:
            as_list = list(tup)
            as_list.sort()
            res.append(as_list)

        res.sort()
        return res

if __name__ == '__main__':
    nums = [1,2,3,4,5,6,7,8,10,0]
    res = Solution().subsets(nums)
    assert hasattr(res, "__iter__")
    for r in res:
        print(r)