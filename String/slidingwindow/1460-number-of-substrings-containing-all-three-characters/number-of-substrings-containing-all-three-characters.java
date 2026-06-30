/*
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length() ,res =0;
        for(int i=0; i<=n-3;i++){
            for(int j=2;j<n;j++){
                String substr = s.substring(i,j+1);
                if(substr.contains("a") && substr.contains("b")&& substr.contains("c")){
                    res ++;
                }
            }
        }
        return res;
    }
}
*/

class Solution {
    public int numberOfSubstrings(String s) {
        int freq[] = new int[3];
        int i = 0,j = 0,res=0,n=s.length();
        while(j< n){
            freq[s.charAt(j)-'a']++;
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                res += (n-j);
                freq[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return res;
    }
}