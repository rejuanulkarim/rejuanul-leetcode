/*
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
*/
class Solution {
    public int maxNumberOfBalloons(String text) {
        int b = 0, a=0,l=0,o=0,n=0;
        for(char ch:text.toCharArray()){
            switch(ch){
               case  'b': b++; break;
               case  'a': a++; break;
               case  'l': l++; break;
               case  'o': o++; break;
               case  'n': n++; break;
            }
        }
        return Math.min(b,Math.min(a,Math.min(n,Math.min(l/2,o/2))));
    }
}