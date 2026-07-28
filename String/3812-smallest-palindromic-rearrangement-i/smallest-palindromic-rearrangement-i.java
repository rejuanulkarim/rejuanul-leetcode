class Solution {
    public String smallestPalindrome(String s) {
        int [] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for(int i =0;i<26;i++){
            int n = freq[i]/2;
            while(n > 0){
                sb.append(c);
                n--;
            }
            c++;
        }
        c = 'a';
        for(int i=0; i<26;i++){
            if(freq[i]%2 == 1) sb.append(c);
            c++; 
        }
        c = 'z';
        for(int i =25;i>=0;i--){
            int n = freq[i]/2;
            while(n > 0){
                sb.append(c);
                n--;
            }
            c--;
        }
        return sb.toString();
    }
}