class Solution {
    int smallIndex(int[] nums){
        int l=0, r= nums.length-1;
        while(l<r){
            int m = l+(r-l)/2;
            while(l<r && nums[l] == nums[l+1]) l++;
            while(l<r && nums[r] == nums[r-1]) r--;
            if(nums[m] > nums[r]) l = m+1;
            else  r = m;
        }
        return l;
    }
    boolean srch(int[] nums,int target,int l, int r){
        while(l<=r){
            int m = l+(r-l)/2;
            if(nums[m] == target) return true;
            if(target < nums[m] || nums[m] == nums[r]) r = m-1;
            else l = m+1;
        }
        return false;
    }
    public boolean search(int[] nums, int target) {
        int idx = smallIndex(nums);
        boolean res = srch(nums,target,0,idx-1);
        if(res) return true;
        return srch(nums,target,idx,nums.length-1);
    }
}