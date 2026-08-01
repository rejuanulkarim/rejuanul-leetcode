class Solution {
    public boolean predictTheWinner(int[] nums) {
        return solve(nums,0,nums.length - 1,0,0,true);
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