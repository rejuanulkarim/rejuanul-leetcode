class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x:(x[0],-x[1]))
        maxEnd = 0
        res = 0
        for _,x in intervals:
            if x > maxEnd:
                maxEnd = x
                res +=1
        return res
