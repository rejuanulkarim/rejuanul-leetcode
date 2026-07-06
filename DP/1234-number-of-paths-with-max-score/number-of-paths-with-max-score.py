class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        n = len(board)
        MOD = 10**9+7
        dp =[[(0,0)]*n for _ in range(n)]
        dp[0][0] = (0,1)

        for i in range(1,n):
            ch = board[0][i]
            pre = dp[0][i-1]
            if ch == 'X' or pre[1] == 0:
                dp[0][i] = (0,0)
            else:
                dp[0][i] = (int(ch)+pre[0],1)

        for i in range(1,n):
            ch = board[i][0]
            pre = dp[i-1][0]
            if ch == 'X' or pre[1] == 0:
                dp[i][0] = (0,0)
            else:
                dp[i][0] = (int(ch)+pre[0],1)
        
        for i in range(1,n):
            row = board[i]
            for j in range(1,n):
                ch = row[j]
                if(ch == 'X'):
                    dp[i][j] = (0,0)
                    continue
                up = dp[i-1][j]
                left = dp[i][j-1]
                upleft = dp[i-1][j-1]
                val = 0 if ch == 'S' else int(ch)
                path = 0
                best = max(up[0],left[0],upleft[0])
                if best == up[0]:
                    path = (path + up[1])%MOD
                if best == left[0]:
                    path = (path+left[1])%MOD
                if best == upleft[0]:
                    path = (path+upleft[1])%MOD
                if path != 0:
                    val += best
                dp[i][j] = (val,path)
        
        return list(dp[n-1][n-1])
                      