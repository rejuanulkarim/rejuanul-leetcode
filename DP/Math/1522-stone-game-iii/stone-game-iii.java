/*
class Solution {
    Integer dp[];
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new Integer[n];
        int diff = solve(stoneValue,0);
        if(diff<0) return "Bob";
        if(diff > 0) return "Alice";
        return "Tie"; 
    }
    private int solve(int[] nums,int i){
        int n = nums.length;
        if(i >= n) return 0;
        if(dp[i] != null) return dp[i];
        int diff = Integer.MIN_VALUE;
        diff = Math.max(diff, nums[i] - solve(nums,i+1));
        if(i+1 < n) diff = Math.max(diff, nums[i]+nums[i+1] - solve(nums,i+2));
        if(i+2 < n) diff = Math.max(diff,nums[i]+nums[i+1]+nums[i+2] - solve(nums,i+3));
        return dp[i]=diff;
    }
}
*/
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int dp[] = new int[n+1];
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            dp[i] = stoneValue[i] - dp[i+1];
            if(i+2 <= n) dp[i] = Math.max(dp[i],stoneValue[i]+stoneValue[i+1] - dp[i+2]);
            if(i+3 <= n) dp[i] = Math.max(dp[i],stoneValue[i]+stoneValue[i+1]+stoneValue[i+2] - dp[i+3]);
        }
        if(dp[0] < 0) return "Bob";
        if(dp[0]> 0) return "Alice";
        return "Tie";
    }
}