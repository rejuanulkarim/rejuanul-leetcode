class Solution {
    public int maximumProduct(int[] nums) {
        int fMax = -1001,sMax = -1001,tMax= -1001;
        int fMin = 1001, sMin = 1001;
        for(int num:nums){
            if(num > fMax){
                tMax=sMax;
                sMax=fMax;
                fMax=num;
            }else if(num >sMax){
                tMax=sMax;
                sMax=num;
            }else if( num >tMax) tMax = num;
            if(num < fMin){
                sMin = fMin;
                fMin = num;
            }else if(num < sMin) sMin = num;
        }
        return Math.max(fMax*sMax*tMax,fMin*sMin*fMax);
    }
}