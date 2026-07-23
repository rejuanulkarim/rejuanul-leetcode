class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n==1 || n==2) return n;
        int res=4;
        while(res <= n) res = res<<1;
        return res;
    }
}