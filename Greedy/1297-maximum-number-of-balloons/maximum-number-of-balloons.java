class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] arr = new int [26];
        for(int i=0;i<text.length();i++){
            arr[text.charAt(i)-'a']++;
        }
        int res = Integer.MAX_VALUE;
        res = Math.min(res,arr['b'-'a']);
        res = Math.min(res,arr['a'-'a']);
        res = Math.min(res,arr['o'-'a']/2);
        res = Math.min(res,arr['l'-'a']/2);
        return res = Math.min(res,arr['n'-'a']);
    }
}