class Solution {
    int dp[][];
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int total = 0;
        for(int pile:piles) total += pile;
        int alice = solve(piles,0,n-1);
        return alice > total - alice;
    }
    private int solve(int[] nums, int left,int right){
        if(left>right) return 0;
        if(left == right) return nums[left];
        if(dp[left][right] != -1) return dp[left][right];
        int p1 = solve(nums,left+2,right);
        int p2 = solve(nums,left+1,right-1);
        int p3 = solve(nums,left,right-2);
        int takeLeft = nums[left]+Math.min(p1,p2);
        int takeRight = nums[right] + Math.min(p2,p3);
        return dp[left][right] = Math.max(takeLeft,takeRight);
    }
}