class Solution {
    public char processStr(String s, long k) {
        long l =0;

        for(char ch :s.toCharArray()){
            if(ch == '*'){
                if(l > 0){
                    l--; // last character remove so length 1 decrease
                }
            }else if(ch == '#'){
                l *=2; // length is double
            }else if(ch == '%'){
                // no change in length
                continue;
            }else{
                l++; // a to z append 
            }
        }

        if(l <= k) return '.'; // out of index 

        // reverses the process
        for(int i = s.length()-1; i>=0;i--){
            char ch = s.charAt(i);
            if(ch == '*'){
                l++; // because removes last character reverses it
            }else if(ch == '#'){
                l = l/2;
                if( l <= k) k = k-l; //  
            }else if(ch == '%'){
                // l not change for reverse;
                k = l -k-1;
            }
            else{
                l--;
            }

            if(k==l) return ch;
        }
        return '.';
    }
}