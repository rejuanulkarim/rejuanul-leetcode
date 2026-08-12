class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int i =0, j=0,res=0;
        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(i <j && map.get(nums[j]) > k) map.put( nums[i] ,map.get(nums[i++])-1);
            res = Math.max(res,j-i+1);
            j++;
    }
    return res;
}
}