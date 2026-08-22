class Solution {
    public boolean checkDivisibility(int n) {
        long sum = 0;
        long mul= 1;
        long orgN = n;
        while(n>0){
            int r = n%10;
            sum +=r;
            mul *=r;
            n /=10;
        }
        return orgN % (sum + mul) == 0;
    }
}