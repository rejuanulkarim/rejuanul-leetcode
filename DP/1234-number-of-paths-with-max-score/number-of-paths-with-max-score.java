class Solution {
    int MOD = 1000000007;

    class Pair{
        int sum;
        int path;
        Pair(int sum, int path){
            this.sum = sum;
            this.path = path;
        }
    }

    public int[] pathsWithMaxScore(List<String> board) {
        int m = board.size();
        int n = board.get(0).length();
        Pair[][] dp = new Pair[m+1][n+1];
        dp[0][0] = new Pair(0,1);

        for(int i=1;i<n;i++){
            char ch = board.get(0).charAt(i);
            Pair pre = dp[0][i-1];
            if(ch == 'X' || pre.path == 0) dp[0][i] = new Pair(0,0);
            else dp[0][i] = new Pair((ch-'0')+pre.sum,1);
        }

        for(int i=1;i<m;i++){
            char ch = board.get(i).charAt(0);
            Pair pre = dp[i-1][0];
            if(ch == 'X' || pre.path == 0) dp[i][0] = new Pair(0,0);
            else dp[i][0] = new Pair((ch-'0')+pre.sum,1);
        }

        for(int r= 1;r<m;r++){
            char [] currRow = board.get(r).toCharArray();
            for(int c = 1;c<n;c++){
                int sum =0, path = 0;
                if(currRow[c] == 'X'){
                    dp[r][c] = new Pair(sum,path);
                    continue;
                }
                int val =(currRow[c] =='S')?0: currRow[c] -'0';
                int upSum = dp[r-1][c].sum;
                int upPath = dp[r-1][c].path;
                int leftSum = dp[r][c-1].sum;
                int leftPath = dp[r][c-1].path;
                int upLeftSum = dp[r-1][c-1].sum;
                int upLeftPath = dp[r-1][c-1].path;
                if(upSum == leftSum && upSum == upLeftSum){

                    sum = val + upSum;
                    path = (upPath + leftPath + upLeftPath)%MOD;

                }else if(upSum == leftSum && upSum > upLeftSum){

                    sum = val + upSum;
                    path = (upPath + leftPath)%MOD;

                }else if(upSum == upLeftSum && upSum > leftSum){

                    sum = val + upSum;
                    path = (upPath + upLeftPath)%MOD;

                }else if(leftSum == upLeftSum && leftSum > upSum){

                    sum = val +  leftSum;
                    path = (leftPath + upLeftPath)%MOD;

                }else{
                    if(upSum > leftSum && upSum > upLeftSum){
                        sum = val + upSum;
                        path = upPath;
                    }else if (leftSum > upLeftSum){
                        sum = val+ leftSum;
                        path = leftPath;
                    }else{
                        sum = val + upLeftSum;
                        path = upLeftPath;
                    }
                }
                if(path == 0) sum = 0;
                dp[r][c] = new Pair(sum,path);
            } 
        }
        Pair res = dp[m-1][n-1];
        return new int[]{res.sum,res.path};
    }
}