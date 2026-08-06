class Solution {
    public int smallestNumber(int n, int t) {
        boolean flag = true;
        int orgN = n;
        while(flag){
            int product = 1;
            while(n > 0){
                product *= n%10;
                n /= 10;
            }
            if(product % t == 0) flag = false;
            n = ++orgN;
        }
        return orgN-1;
    }
}