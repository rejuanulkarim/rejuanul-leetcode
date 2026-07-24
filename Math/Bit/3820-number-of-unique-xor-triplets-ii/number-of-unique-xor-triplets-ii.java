class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n==1) return n;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            max = Math.max(max,num);
        }
        int len =1;
        while(len <= max) len = len<<1;
        boolean [] pairXor = new boolean[len];
        HashSet<Integer> res = new HashSet<>();
        
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                pairXor[nums[i]^nums[j]] = true;
            }
        }
        for(int k=0;k<len;k++){
            if(pairXor[k]){
            for(int i=0;i<n;i++){
                res.add(k ^ nums[i]);
            }
            }
        }
        return res.size();
    }
}