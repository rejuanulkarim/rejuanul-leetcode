class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int [] dp =new int [n+1];
        dp[0] =0;
        for(int i=0;i<n;i++){
            dp[i+1] = dp[i]+nums[i];
        }
        return Math.max(solve(dp,firstLen,secondLen),solve(dp,secondLen,firstLen));
    }
    private int solve(int[] nums, int l, int m){
        int n = nums.length;
        int sum1 =0, sum2=0 , ans =0;
        for(int i=0;i < n-l-m;i++){
            sum1 = Math.max(nums[i+l]-nums[i],sum1);
            sum2 =nums[i+m+l]-nums[i+l];
            ans = Math.max(ans, sum1+sum2);
        }
        return ans;
    }
}