class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int N=n;
        int M = r-l+1;
        long MOD = (long)1e9+7;
        long t[][][] = new long [N+1][M+1][2];
        for(int i=1;i <= M;i++){
            t[N][i][0] =1;
            t[N][i][1] = 1;
        }
        for(int i = N-1;i>=0;i--){
            long cumSum1[] = new long [M+1];
            long cumSum0[] = new long [M+1];

            for(int val=1;val<=M;val++){
                cumSum0[val] = (cumSum0[val-1]+t[i+1][val][0])%MOD;
                cumSum1[val] = (cumSum1[val-1]+ t[i+1][val][1])%MOD;
            }

            for(int prevVal =1;prevVal <= M; prevVal++){
                t[i][prevVal][1] = (cumSum0[M]-cumSum0[prevVal]+MOD)%MOD;
                t[i][prevVal][0] = cumSum1[prevVal-1];
            }
        }
        long result =0;
        for(int startVal =1;startVal<=M;startVal++){
            result = (result + t[1][startVal][1])%MOD;
            result = (result + t[1][startVal][0])%MOD;
        }
        return (int)result;
    }
}