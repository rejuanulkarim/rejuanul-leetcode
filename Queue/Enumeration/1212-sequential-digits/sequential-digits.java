class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=1 ;i<9;i++){
            q.addLast(i);
        }
        while(!q.isEmpty()){
            int num = q.removeFirst();
            if(num >= low){
                list.add(num);
            }
            int digit = num%10;
            num = num*10 + ++digit;
            if(digit <= 9 && num <= high) q.addLast(num);
        }
        return list;
    }
}