class Solution {
    public int minimumPushes(String word) {
        int[] dp = new int[26];
        for(char ch:word.toCharArray()){
            dp[ch-'a']++;
        }
        Arrays.sort(dp);
        int res =0;
        for(int i = 25,count=1,press =1;i>=0;i--){
            if(count > 8){
                count =1;
                press++;
            }
            res += dp[i]*press;
            count++;
        }
        return res;
    }
}