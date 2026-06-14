class Solution:
    # m = row , n = col - max limit
    def solve(self,mat,row,col,m,n,dp):
        if row > m or col > n or mat[row][col] == 1: return 0
        if row == m and col == n : return 1
        if dp[row][col] != -1: return dp[row][col]
        right = self.solve(mat,row,col+1,m,n,dp)
        bottom = self.solve(mat,row+1,col,m,n,dp)
        dp[row][col] = right + bottom
        return dp[row][col]
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        row = len(obstacleGrid)
        col = len(obstacleGrid[0])
        dp = [[-1]*col for _ in range(row)]
        return self.solve(obstacleGrid,0,0,row-1,col-1,dp)