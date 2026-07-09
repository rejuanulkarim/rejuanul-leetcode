class Solution:
    def pathExistenceQueries(self, n: int, nums: List[int], maxDiff: int, queries: List[List[int]]) -> List[bool]:
        component =[]
        cmpt = 0
        component.append(cmpt)
        for i in range(1,len(nums)):
            if nums[i] - nums[i-1] > maxDiff: cmpt +=1
            component.append(cmpt)
        res = []
        for u,v in queries:
            res.append(component[u] == component[v])
            
        return res

