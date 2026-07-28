/*
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
*/

class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int freq[] = new int [26];
        for(int ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        char [] res = new char[n];
        char c = 'a';
        int left = 0;
        int right = n-1;
        for(int i=0;i<26;i++){
            while(freq[i] >= 2){
                res[left++] = c;
                res[right --] = c;
                freq[i] -=2;
            }
            c++;
        }
        c='a';
        for(int i=0;i<26;i++){
            if(freq[i] == 1) res[left] = c;
            c++;
        }

        return new String(res);
    }
}