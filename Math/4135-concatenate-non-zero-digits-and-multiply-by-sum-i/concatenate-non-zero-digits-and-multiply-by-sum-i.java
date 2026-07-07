class Solution {
    public long sumAndMultiply(int n) {
        int num =0; 
        int sum =0,base=1;
        while(n>0){
            int r = n%10;
            n /=10;
            if(r == 0) continue;
            num += base*r;
            base *=10;
            sum += r;
        }
        return (long)sum * num;
    }
}