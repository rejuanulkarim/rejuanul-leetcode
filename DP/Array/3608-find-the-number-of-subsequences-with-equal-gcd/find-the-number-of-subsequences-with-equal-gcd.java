class Solution {
    int MOD = 1000000007;
    Integer dp[][][];
    public int subsequencePairCount(int[] nums) {
        int n = nums.length, maxNum = Integer.MIN_VALUE;
        for(int num:nums){
            maxNum = (maxNum > num)? maxNum: num;
        }
        dp =  new Integer[n+1][maxNum+1][maxNum+1];
        
        return solve(nums,0,0,0);
    }
    int solve(int[] nums,int idx, int first, int second){
        if(idx == nums.length){
            return (first != 0 && first == second) ?1:0;
        }
        if(dp[idx][first][second] != null) return dp[idx][first][second];
        long skip = solve(nums,idx+1,first,second);
        long take1 = solve(nums,idx+1,gcd(first,nums[idx]),second);
        long take2 = solve(nums, idx+1,first,gcd(second,nums[idx]));
        return dp[idx][first][second] = (int)((skip + take1 + take2)%MOD);
    }
    int gcd(int a, int b){
        while (b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}