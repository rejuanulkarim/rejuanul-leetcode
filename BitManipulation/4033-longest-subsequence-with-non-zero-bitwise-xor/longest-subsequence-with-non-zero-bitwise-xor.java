/*
class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int zero = 0,xor=0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0) zero++;
            xor ^= nums[i];
        }
        if(zero == n) return 0;
        return (xor == 0)? n-1:n;
    }
}
*/

class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int zero = 0,xor=0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0) zero++;
            xor ^= nums[i];
        }
        if(xor != 0) return n;
        else if(zero == n) return 0;
        return n-1;
    }
}