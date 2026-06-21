class Solution {
    Boolean [][] dp;
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int num:nums) sum += num;
        if(sum%2 == 1) return false;
        dp = new Boolean[1+ sum/2][nums.length+1];
        return canSubsets(nums,sum/2,0);
    }
    boolean canSubsets(int[] nums,int remain,int idx){
        if(remain == 0) return true;
        if(idx >= nums.length || remain < 0) return false;
        if(dp[remain][idx] != null) return false;
        boolean take = canSubsets(nums,remain - nums[idx],idx+1);
        boolean skip = canSubsets(nums,remain,idx+1);
        return dp[remain][idx]= take || skip ;
    } 
}