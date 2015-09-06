__author__ = 'markdaniel'
class Solution(object):
    def word_break(self, s, wordDict):
        wordSet = set(wordDict)
        if wordDict == None or len(wordDict) == 0 or len(s) == 0:
            return False
        min_word_len = len(s)
        max_word_len = -1
        for word in wordSet:
            if len(word) < min_word_len:
                min_word_len = len(word)
            if len(word) > max_word_len:
                    max_word_len = len(word)
        bridges = [0] * len(s)
        for x in xrange(max_word_len):
            word = s[0:x + 1]
            if word in wordDict:
                bridges[x] += 1

        currentStretch = 0
        for x in xrange(len(s) + 1 - min_word_len):
            currentStretch += 1
            if bridges[x] > 0:
                y = x + 2
                z = x + 1
                while y < (z + max_word_len + 1) and y <= len(s):
                    word = s[z:y]
                    if word in wordDict:
                        bridges[y - 1] += 1
                    y += 1
                currentStretch = 0
            else:
                if currentStretch >= max_word_len:
                    return False
        return bridges[len(s) - 1] > 0

if __name__=='__main__':
    s = "ab"
    dict = ["a", "b"]
    res = Solution().wordBreak(s, dict)
    print(res)

