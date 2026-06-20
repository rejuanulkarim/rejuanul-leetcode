class Solution {
    boolean canSplit(int[] nums, int k, int maxSum){
        int count = 1 , currSum = 0; 
        for(int num:nums){
            if(num > maxSum) return false; // if subarrays sum must >= any element of array
            if(currSum + num > maxSum){
                count++;
                currSum = num;
            }else{
                currSum += num;
            }
        }
        if(k < count) return false;
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int high = 0,low = nums[0]; // low must be >= fast one because its contiquous;
        for(int num:nums){
            high += num;// high must be <= total sum;
        }
        int res = -1;
        while(low <=  high){
            int mid = low + (high-low)/2;
            if(canSplit(nums,k,mid)){
                res = mid; // uptade result every time is true
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }
}