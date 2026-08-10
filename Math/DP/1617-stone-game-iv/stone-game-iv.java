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
            int m = n-(i*i);
            dp[m] = solve(m);
            if(! dp[m]) return true; 
        }
        return dp[n] = false;
    }
}