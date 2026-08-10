/*
class Solution {
    Boolean [] dp;
    public boolean winnerSquareGame(int n) {
        dp = new Boolean[n+1];
        return solve(n);
    }
    boolean solve(int n){
        if(n==0) return false;
        if(dp[n] != null) return dp[n];
        for(int i=1;i*i <= n;i++){
            if(!solve(n-i*i)) return dp[n] = true;
        }
        return dp[n] = false;
    }
}
*/
class Solution {
    public boolean winnerSquareGame(int n) {
        boolean dp[] = new boolean[n+1];
        for(int i=1; i<n+1;i++){
            for(int j=1;j*j <= i;j++){
                if(! dp[i-(j*j)] ) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}