class Solution {
    public int minimumPushes(String word) {
        int[] dp = new int[27];
        for(char ch:word.toCharArray()){
            dp[ch-'a']++;
        }
        Arrays.sort(dp);
        int idx = 26;
        int flag = 1,press =1,res = 0,sum = 0;
        while(dp[idx] > 0){
            if(flag > 8 ){
                res += press* sum;
                sum = 0;
                flag = 1;
                press++;
            }
            sum += dp[idx--];
            flag++;
        }
        res += press* sum;
        return res;
    }
}