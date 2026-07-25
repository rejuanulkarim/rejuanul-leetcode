class Solution {
    public int maxProduct(int n) {
        int fastMax = n%10;
        n/=10;
        int secMax = 0;
        while(n>0){
            int temp = n%10;
            n /=10;
            if(fastMax < temp){
                secMax = fastMax;
                fastMax = temp;
            }else if(secMax < temp) secMax = temp;
        }
        return fastMax*secMax;
    }
}