class Solution:
    def solve(self, nums, curr, n,dp):
        if curr > n : return 0
        if dp[curr] != -1: return dp[curr]
        take = nums[curr] + self.solve(nums,curr+2,n,dp)
        skip = self.solve(nums,curr+1,n,dp)
        dp[curr] = max(take , skip)
        return dp[curr]
    def rob(self, nums: List[int]) -> int:
        n = len(nums)-1
        if len(nums) == 1: return nums[0]
        dp = [-1]*(n+1)
        # fast house take
        fTake = self.solve(nums,0,n-1,dp)
        # fast one skip
        dp = [-1]*(n+1)
        fSkip = self.solve(nums,1,n,dp)
        return max(fTake,fSkip)