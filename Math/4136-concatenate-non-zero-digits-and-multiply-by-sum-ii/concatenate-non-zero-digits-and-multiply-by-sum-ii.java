/*
class Solution {
    public int[] sumAndMultiply(String str, int[][] queries) {
        int MOD = 1000000007;
        int n= str.length(),nq = queries.length;
        long [][] arr = new long[n+1][3]; // arr[0] -> sum,num,nonZero
        arr[0][0] = 0;
        arr[0][1] =0;
        arr[0][2] =0;
        for(int i = 0;i<n;i++){
            int num = str.charAt(i)-'0';
            arr[i+1][0] = arr[i][0] + num;
            arr[i+1][1] = arr[i][1];
            arr[i+1][2] = arr[i][2];
            if(num > 0){
                arr[i+1][1] = arr[i+1][1]*10 + num;
                arr[i+1][2]++;
            }
        }
        int res [] = new int[nq];
        for(int i =0;i<nq;i++){
            int s = queries[i][0] , e = queries[i][1]+1;
            int sum = (int) (arr[e][0] - arr[s][0]);
            int len = (int) (arr[e][2] - arr[s][2]);
            long num = (arr[e][1] - arr[s][1]*(long)Math.pow(10,len));
            res[i] = (int)(num%MOD * sum%MOD);
        }
        return res;
    }
}
*/

class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final int MOD = 1_000_000_007;
        int n = s.length();

        // prefixSum[i] = sum of digits in s[0..i-1]
        int[] prefixSum = new int[n + 1];

        // nzCount[i] = number of non-zero digits in s[0..i-1]
        int[] nzCount = new int[n + 1];

        // prefixNum[i] = concatenation of non-zero digits in s[0..i-1] modulo MOD
        long[] prefixNum = new long[n + 1];

        // pow10[i] = 10^i % MOD
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            prefixSum[i + 1] = prefixSum[i] + d;
            nzCount[i + 1] = nzCount[i];
            prefixNum[i + 1] = prefixNum[i];

            if (d != 0) {
                nzCount[i + 1]++;
                prefixNum[i + 1] = (prefixNum[i + 1] * 10 + d) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1] + 1;

            int sum = prefixSum[r] - prefixSum[l];
            int cnt = nzCount[r] - nzCount[l];

            long num = (prefixNum[r] - (prefixNum[l] * pow10[cnt]) % MOD + MOD) % MOD;

            ans[i] = (int) ((num * sum) % MOD);
        }

        return ans;
    }
}