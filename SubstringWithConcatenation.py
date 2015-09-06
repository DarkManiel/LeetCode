__author__ = 'markdaniel'
class Solution(object):
    def findSubstring(self, s, words):
        if len(words) == 0 or len(s) == 0:
            return []
        wordLen = len(words[0])
        numWords = len(words)
        if len(s) < wordLen:
            return []
        res = []
        wordDict = {}
        for word in words:
            if not wordDict.has_key(word):
                wordDict[word] = 1
            else:
                wordDict[word] += 1

        for x in xrange(len(s) + 1 - numWords * wordLen):
            y = 0; candidates = {}
            while y < numWords:
                word = s[x + y * wordLen: x + y * wordLen + wordLen]
                if word not in wordDict:
                    break
                else:
                    if word in candidates:
                        if candidates[word] < wordDict[word]:
                            candidates[word] += 1
                        else:
                            break
                    else:
                        candidates[word] = 1
                y += 1
                if y == numWords:
                    res.append(x)
        return res
if __name__ == '__main__':
    s = "abababab"
    words = ["a","b","a"]
    res = Solution().findSubstring(s, words)
    for val in res:
        print(val)

