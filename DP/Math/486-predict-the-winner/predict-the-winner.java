/*
class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        return solve(nums,0,n - 1,0,0,true);
    }
    boolean solve(int[] nums,int left,int right,int p1,int p2,boolean flag){
        if(left > right) return p1 >= p2;
        boolean take1 = false, take2 = false , res = false;
        if(flag){
            take1 = solve(nums,left+1,right,p1+nums[left],p2,false);
            take2 = solve(nums,left,right-1,p1+nums[right],p2,false);
            res = take1 || take2;
        }
        else{
            take1 = solve(nums,left+1,right,p1,p2+nums[left],true);
            take2 = solve(nums,left,right-1,p1 ,p2+nums[right],true);
            res = take1 && take2;
        }
        return res;
    }
}
*/

class Solution {
    int dp[][];
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];
        for(int[] arr: dp){
        Arrays.fill(arr,-1);}
        int sum =0;
        for(int num:nums){
            sum += num;
        }
        int player1 = solve(nums,0,n-1);
        return sum - player1 <= player1;
    }
    int solve(int[] nums,int left,int right){
      if(left>right) return 0;
      if(left == right) return nums[left];
      if(dp[right][left] != -1) return dp[right ][ left];
      int take1 = nums[left] + Math.min(solve(nums,left+2,right),solve(nums,left+1,right-1));
      int take2 = nums[right]+ Math.min(solve(nums,left+1,right-1),solve(nums,left,right-2));
      return dp[right][left]=Math.max(take1 , take2);
    }

}