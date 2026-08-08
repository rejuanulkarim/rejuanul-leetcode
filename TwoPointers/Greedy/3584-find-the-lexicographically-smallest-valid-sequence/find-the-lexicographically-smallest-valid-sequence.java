class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int [] matchLen = new int[n];
        int matched =0;
        int i = n-1;
        int j = m-1;
        while(i>= 0 ){
            if(j>=0 && word1.charAt(i) == word2.charAt(j)){
                matched++;
                j--;
            }
            matchLen[i] = matched;
            i--;
        }
        int [] res = new int[m];
        boolean changePower = true;
        int idx = 0;
        i =0;
        j=0;
        while(i<n && j<m){
            if(word1.charAt(i) == word2.charAt(j)){
                res[idx++] = i;
                j++;
            }else if(changePower && i+1 < n  && matchLen[i+1] >= m-j-1){
                res[idx++]=i;
                j++;
                changePower = false;
            } 
            i++;
        }
        return j== m? res: new int[0];
    }
}