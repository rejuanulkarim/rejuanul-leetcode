class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int mul= 1;
        int orgN = n;
        while(n>0){
            int r = n%10;
            sum +=r;
            mul *=r;
            n /=10;
        }
        return orgN % (sum + mul) == 0;
    }
}