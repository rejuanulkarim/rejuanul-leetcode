class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        boolean [] flag = new boolean[51];
        int prefixSum = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i] != nums[i-1]+1) break;
            prefixSum +=nums[i];
        }
        for(int i =0;i<n;i++) flag[nums[i]] = true;
        
        while(prefixSum < 51 && flag[prefixSum]) prefixSum++;
        return prefixSum;
    }
}