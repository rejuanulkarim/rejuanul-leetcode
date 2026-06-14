/*
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dp[] = new int[n];
        dp[0] = grid[0][0];
        for(int i=1;i<n;i++) {dp[i] = dp[i-1]+grid[0][i];}
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    dp[j] = dp[j] + grid[i][j];
                }else{
                    dp[j] = grid[i][j] + Math.min(dp[j-1],dp[j]);
                }
            }
        }
        return dp[n-1];
    }
}
*/

/*
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dp[][] =  new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i=1;i<m;i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for(int j=1;j<n;j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}
*/

class Solution {
    int [][]dp; int m,n;
    public int minPathSum(int[][] grid) {
        m = grid.length; n= grid[0].length;
        dp = new int[m][n];
        for(int[]arr:dp){
            Arrays.fill(arr,-1);
        }
        return minPath(grid,0,0);
    }
    private int minPath(int[][]arr,int i, int j){
        if(i == m-1 && j == n-1) return arr[i][j];
        if(dp[i][j]!= -1) return dp[i][j];
        int sum1 = Integer.MAX_VALUE,sum2=Integer.MAX_VALUE;
        if(i+1 <m) sum1 = arr[i][j] + minPath(arr,i+1,j);
        if(j+1<n ) sum2 = arr[i][j] + minPath(arr,i,j+1);
        return dp[i][j]=Math.min(sum1,sum2);
    }
}
