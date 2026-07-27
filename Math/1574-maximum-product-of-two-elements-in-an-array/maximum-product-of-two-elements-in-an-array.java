class Solution {
    public int maxProduct(int[] nums) {
        int fMax = -1001, lMax = -1001;// fMin = 1001, lMax =1001;
        for(int num:nums){
            if(num > fMax){
                lMax = fMax;
                fMax = num;
            }else if(num > lMax) lMax = num;
        }
        return (fMax-1)*(lMax-1);
    }
}