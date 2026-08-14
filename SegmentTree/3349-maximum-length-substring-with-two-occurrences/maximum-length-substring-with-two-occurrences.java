class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int freq[] = new int[26];
        int i=0,j=0;
        while(j < n){
            char ch = s.charAt(j);
            int idx = ch-'a';
            freq[idx]++;
            while(i<j && freq[idx] > 2){
                freq[s.charAt(i)-'a']--;
                i++;
            }
            j++;
            maxLen = Math.max(maxLen,j-i);
        }
        return maxLen;
    }
}