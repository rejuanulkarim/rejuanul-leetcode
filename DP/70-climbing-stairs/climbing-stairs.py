class Solution:

    def solve(self,n,dp):
        if n == 0: return 1
        if dp[n] != -1 : return dp[n]
        step1 = self.solve(n-1,dp)
        step2 =0
        if n > 1: step2 = self.solve(n-2,dp)
        dp[n] = step1 + step2
        return dp[n]

    def climbStairs(self, n: int) -> int:
        dp = [-1]*(n+1)
        return self.solve(n,dp)