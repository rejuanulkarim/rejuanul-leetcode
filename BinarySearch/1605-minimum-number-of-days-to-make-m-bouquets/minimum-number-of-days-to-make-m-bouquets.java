class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (long)m*k) return -1; // if flowers < required flowers
        int r = Integer.MIN_VALUE;
        for(int day: bloomDay){
            r = Math.max(r,day);
        }
        int l=1 , res = r; 
        // res = maxDay all flowers blooms so bouquet complete 
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isBouquet(bloomDay,m,k,mid)){
                r = mid-1;
                res = Math.min(res,mid); // every time isBouquet is True result update
            }else{
                l =mid+1;
            }
        }
        return res;
    }
    boolean isBouquet(int[]bloomDay,int m, int k,int mid){
        int bouquets =0; 
        int adjFlowers =0;
        for(int day:bloomDay){
            if(day <= mid){   // if i'th day is less than mid day flower bloom alredy 
                adjFlowers++;
            }else{
                adjFlowers =0; // adjacent rules break so reset
            }
            if(adjFlowers == k){ // adjacent flowers required full so 1 bouquets complete
                bouquets++;
                adjFlowers = 0;
            }
        }
        return m <= bouquets;
    }
}