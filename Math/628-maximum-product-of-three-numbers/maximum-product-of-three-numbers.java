class Solution {
    public int maximumProduct(int[] nums) {
        int fMax = Integer.MIN_VALUE;
        int sMax = fMax;
        int tMax = fMax;
        int fMin = Integer.MAX_VALUE, sMin = Integer.MAX_VALUE;
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