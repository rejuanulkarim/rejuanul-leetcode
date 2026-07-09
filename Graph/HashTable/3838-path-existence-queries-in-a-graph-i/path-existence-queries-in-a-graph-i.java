class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int component[] = new int[n];
        int cmp =0;
        component[0] = cmp;
        for(int i=1;i<n;i++){
            if(nums[i] - nums[i-1] > maxDiff){
                cmp++;
            }
            component[i] = cmp;
        }
        int len = queries.length;
        boolean res[] = new boolean[len];
        for(int i=0;i<len;i++){
            int u = queries[i][0];
            int v = queries[i][1];
            res[i] = (component[u] == component[v]);
        }
        return res;
    }
}