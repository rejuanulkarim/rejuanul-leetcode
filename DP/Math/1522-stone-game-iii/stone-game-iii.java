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