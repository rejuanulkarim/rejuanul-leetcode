class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int high = Integer.MIN_VALUE;
        for(int num: nums){
            high = Math.max(high,num);
        } 
        int low = 1, res = high;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(isEqual(nums, threshold, mid)){
                high = mid-1;
                res = Math.min(res, mid);
            }else{
                low = mid+1;
            }
        }  
        return res;
    }
    boolean isEqual(int[] nums, int target, int m){
        int sum =0;
        for(int num:nums){
            sum += (num + m-1)/m;
        }
        return sum <= target;
    }
}