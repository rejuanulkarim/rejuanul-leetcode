class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int sum = 0,max = Integer.MAX_VALUE;
        for(int weight: weights){
            sum += weight;
            max = Math.min(max, weight);
        }
        int l = max, r = sum, res = sum;
        while(l<=r){
            int m =l+(r-l)/2;
            if(isShipped(weights,days,m)){
                res = m;
                r=m-1;
            }else{
                l =m+1;
            }
        }
        return res;
    }
    boolean isShipped(int[] weights, int days,int capacity){
        int count = 0, sum =0;
        for(int weight:weights){
            if(weight > capacity) return false;
            if(sum+weight <= capacity){
                sum += weight;
            }else{
                count++;
                sum = weight;
            }
        }
        count++;
        return count <= days;
    }
}