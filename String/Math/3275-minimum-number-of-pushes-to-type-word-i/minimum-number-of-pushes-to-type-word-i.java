class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int res = 0;
        int press = 1;
        while(n >= 8){
            res += press * 8;
            n -= 8;
            press++;
        }
        return res + n*press;
    }
}