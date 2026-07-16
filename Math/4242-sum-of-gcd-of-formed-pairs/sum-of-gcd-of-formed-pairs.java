class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int mx = 0;
        for(int i=0;i<n;i++){
            if (mx < nums[i] ) mx = nums[i];
            prefixGcd[i] = gcd(mx,nums[i]);
        }
        Arrays.sort(prefixGcd);
        long res = 0;
        for(int i=0;i<n/2;i++){
            res +=gcd(prefixGcd[i],prefixGcd[n-1-i]);
        }
        return res;
    }
    int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}