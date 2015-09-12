__author__ = 'markdaniel'
class Solution(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        res = []
        for x in xrange(2**n):
            bin = "{0:b}".format(x)
            newbin = bin
            for y in xrange(len(bin)):
                if y != 0:
                    digit = (int(bin[y - 1]) + int(bin[y])) % 2
                    newbin = newbin[:y] + str(digit) + newbin[y + 1:]
            res.append(int(newbin, 2))
        return res

if __name__ == '__main__':
    print Solution().grayCode(3)
