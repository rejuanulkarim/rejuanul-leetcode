class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int count =0;
        for(char ch:s.toCharArray()){
            if(ch == '('){
                count++;
                res = Math.max(res, count);
            }
            if(ch ==')'){
                count--;
            }
        }
        return res;
    }
}