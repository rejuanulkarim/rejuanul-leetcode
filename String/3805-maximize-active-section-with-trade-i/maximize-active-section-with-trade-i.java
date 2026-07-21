class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        int currZero = 0, one = 0;
        for(char ch:s.toCharArray()){
            if(ch == '1'){
                if(currZero > 0){
                    list.add(currZero);
                    currZero = 0;
                }
                one++;
            }else{
                currZero++;
            }
        }
        if(currZero >0) list.add(currZero);
        int res = 0;
        for(int i=1;i<list.size();i++){
            res = Math.max(list.get(i-1)+list.get(i) , res);
        }
        return res+one;
    }
}