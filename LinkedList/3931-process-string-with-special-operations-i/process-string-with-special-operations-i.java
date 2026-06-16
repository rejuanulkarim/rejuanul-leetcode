class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c :s.toCharArray()){
            if(c == '*'){
                int len = sb.length();
                if(len > 0) sb.deleteCharAt(len -1);
            }else if(c == '#'){
                sb.append(sb);
            }else if(c == '%'){
                sb.reverse();
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}