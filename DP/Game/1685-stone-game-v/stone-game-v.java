class Solution {
    int dp [][];
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[n][n];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        int sum[] = new int[n+1];
        sum[0] = 0;
        for(int i=0;i<n;i++){
            sum[i+1] = sum[i] + stoneValue[i];
        }
        return solve(0,n-1,sum);
    }
    int solve(int l,int r,int[] sum){
        if(l>=r) return 0;
        if(dp[l][r] != -1) return dp[l][r];
        int score =0;
        for(int m =l;m<r;m++){
            int leftSum = sum[m+1]-sum[l];
            int rightSum = sum[r+1]- sum[m+1];
            if(leftSum < rightSum) score = Math.max(score,leftSum+ solve(l,m,sum));
            else if (leftSum > rightSum) score = Math.max(score,rightSum+ solve(m+1,r,sum));
            else {
                score = Math.max(score,Math.max(leftSum+ solve(l,m,sum),rightSum+ solve(m+1,r,sum)));
            }
        }
        return dp[l][r] =score;
    }
}