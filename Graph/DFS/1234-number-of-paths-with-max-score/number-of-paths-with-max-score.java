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
                dp[0][i] = new Pair(pre.sum +(ch-'0') , pre.path);
            }else dp[0][i] = new Pair(0,0);
        }
        for(int i=1;i<r;i++){
            Pair pre = dp[i-1][0];
            char ch = board.get(i).charAt(0);
            if(ch != 'X' && pre.path != 0){
                dp[i][0] = new Pair(pre.sum +(ch-'0') , pre.path);
            }else dp[i][0] = new Pair(0,0);
        }

        for(int i=1;i<r;i++){
            char[] preRow = board.get(i-1).toCharArray();
            char[] currRow = board.get(i).toCharArray();
            for(int j=1;j<c;j++){
                int sum = 0;
                int path =0;
                dp[i][j] = new Pair(sum,path);
                if(currRow[j] == 'X'){
                    continue;
                }
                Pair left = dp[i][j-1];
                Pair up = dp[i-1][j];
                Pair upLeft = dp[i-1][j-1];
                int val =(currRow[j] != 'S')? currRow[j]-'0':0;
                if(up.path == 0 && upLeft.path == 0 && left.path == 0 ) continue;
                if(up.sum == upLeft.sum && up.sum == left.sum){
                    sum =(val + up.sum)%MOD;
                    path = (up.path + left.path + upLeft.path)% MOD;
                }else if( up.sum == left.sum && upLeft.sum  < up.sum){
                    sum =(val + up.sum)%MOD;
                    path = (up.path + left.path )% MOD;
                }else if(up.sum == upLeft.sum && left.sum < up.sum){
                    sum =(val + up.sum)%MOD;
                    path = (up.path + upLeft.path)% MOD;
                }else if(upLeft.sum == left.sum && up.sum < left.sum){
                    sum =(val + upLeft.sum)%MOD;
                    path = (left.path + upLeft.path)% MOD;
                }else{
                    if(up.sum > left.sum && up.sum > upLeft.sum){
                        sum = (val + up.sum)%MOD;
                        path = up.path;
                    }else if(left.sum > up.sum && left.sum > upLeft.sum){
                        sum = (val + left.sum)%MOD;
                        path = left.path;
                    }else{
                        sum = (val + upLeft.sum)%MOD;
                        path = upLeft.path;
                    }
                }
                if(path == 0) continue;
                dp[i][j] = new Pair(sum,path);
            }
        }

        Pair res = dp[r-1][c-1];
        return new int[]{res.sum, res.path};
    }
}