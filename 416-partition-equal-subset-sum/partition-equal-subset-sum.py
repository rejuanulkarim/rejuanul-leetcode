class Solution:
    def canSubsets(self,nums,remender,idx,dp):
        if(remender == 0) :return True
        if(idx >= len(nums) or remender < 0): return False
        if(dp[remender][idx] != -1): return dp[remender][idx]
        take = self.canSubsets(nums,remender - nums[idx],idx+1,dp)
        skip = self.canSubsets(nums,remender,idx+1,dp)
        dp[remender][idx] = take or skip
        return dp[remender][idx]
    def canPartition(self, nums: List[int]) -> bool:
        sum1 = sum(nums)
        if(sum1%2 == 1): return False
        target = sum1//2
        dp = [[-1]* len(nums) for _ in range(target+1)]
        return self.canSubsets(nums,target,0,dp)
        