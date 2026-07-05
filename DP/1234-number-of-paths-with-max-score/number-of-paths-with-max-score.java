class Solution {
    int MOD  = 1000000007;
    class Pair{
        int sum;
        int path;
        Pair(int sum, int path){
            this.sum = sum;
            this.path = path;
        } 
    }
    public int[] pathsWithMaxScore(List<String> board) {
        int r = board.size(), c=board.get(0).length();
        Pair [][] dp = new Pair [r+1][c+1];
        dp[0][0] = new Pair(0,1);
        for(int i=1;i<c;i++){
            Pair pre = dp[0][i-1];
            char ch = board.get(0).charAt(i);
            if(ch != 'X' && pre.path != 0){
                dp[0][i] = new Pair(pre.sum +(ch-'0') , 1);
            }else dp[0][i] = new Pair(0,0);
        }
        for(int i=1;i<r;i++){
            Pair pre = dp[i-1][0];
            char ch = board.get(i).charAt(0);
            if(ch != 'X' && pre.path != 0){
                dp[i][0] = new Pair(pre.sum +(ch-'0') , 1);
            }else dp[i][0] = new Pair(0,0);
        }

        for(int i=1;i<r;i++){
            char[] currRow = board.get(i).toCharArray();
            for(int j=1;j<c;j++){
                int sum = 0;
                int path =0;
                if(currRow[j] == 'X'){
                    dp[i][j] = new Pair(sum,path);
                    continue;
                }
                Pair left = dp[i][j-1];
                Pair up = dp[i-1][j];
                Pair upLeft = dp[i-1][j-1];
                int val =(currRow[j] != 'S')? currRow[j]-'0':0;
                int best = Math.max(up.sum, Math.max(left.sum, upLeft.sum));
                if (best == up.sum) {
                     path = (path + up.path) % MOD;
                }
                if (best == left.sum) {
                    path = (path + left.path) % MOD;
                }
                if (best == upLeft.sum) {
                path = (path + upLeft.path) % MOD;
                }
                if (path != 0) {
                    sum = val + best;
                }
                dp[i][j] = new Pair(sum,path);
            }
        }

        Pair res = dp[r-1][c-1];
        return new int[]{res.sum, res.path};
    }
}