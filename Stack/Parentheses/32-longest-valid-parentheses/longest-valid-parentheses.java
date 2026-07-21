class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int res = 0;
        if(n==0) return res;

        ArrayList<Integer> st = new ArrayList<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int idx = st.size()-1;
            if(!st.isEmpty() && ch == ')' && s.charAt(st.get(idx)) == '('){
                st.remove(idx);
            }else st.add(i);
        }
        if(st.isEmpty()) return n;
        st.add(0,-1);
        st.add(n);
        for(int i=1;i<st.size();i++){
            res = Math.max(res, st.get(i)-st.get(i-1)-1);
        }
        return res;
    }
}