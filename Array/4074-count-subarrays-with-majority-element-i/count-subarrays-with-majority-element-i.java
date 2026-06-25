class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] prefex = new int [n+1];
        prefex[0] = 0;
        for(int i = 1;i <= n;i++){
            prefex[i] = prefex[i-1] + ((nums[i-1] == target)?1:0); 
        }
        int res = 0;
        for(int len = 1; len <=n;len++){
            for(int i=0; i <= n-len;i++){
                int count = prefex[i+len] - prefex[i];
                if(count > len/2) res++;
            }
        }
        return res;
    }
}