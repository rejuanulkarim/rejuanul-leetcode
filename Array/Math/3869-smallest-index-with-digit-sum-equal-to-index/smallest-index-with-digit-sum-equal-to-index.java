class Solution {
    public int smallestIndex(int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int i =0; i< nums.length;i++){
            int num = nums[i];
            int sum =0;
            while(num > 0){
                sum += num%10;
                num/=10;
            }
            if(sum == i)res = Math.min(res,sum);
        }
        return (res == Integer.MAX_VALUE)? -1: res;
    }
}