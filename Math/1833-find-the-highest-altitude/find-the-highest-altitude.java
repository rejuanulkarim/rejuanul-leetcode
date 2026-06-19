class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0 , curr =0;
        for(int altitude :gain){
            curr += altitude; 
            res = (res > curr)?res:curr;
        }
        return res;
    }
}