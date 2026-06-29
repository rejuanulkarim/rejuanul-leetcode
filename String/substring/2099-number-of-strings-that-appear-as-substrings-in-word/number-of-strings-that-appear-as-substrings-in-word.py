class Solution:
    def numOfStrings(self, patterns: List[str], word: str) -> int:
        res = 0
        for s in patterns:
           if word.count(s):
            res +=1
        return res