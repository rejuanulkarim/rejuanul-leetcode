class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        int res = 0;
       Arrays.sort(intervals,(a,b)->{
            if(a[0] == b[0]) return b[1] - a[1]; // for largest intervals fast
            return a[0] - b[0]; // fast starting point fast
       });
       int maxEnd = 0;
       for(int i=0;i<n;i++){
        if(maxEnd < intervals[i][1]){
            maxEnd = intervals[i][1];
            res++;
        }
       }
        return res;
    }
}