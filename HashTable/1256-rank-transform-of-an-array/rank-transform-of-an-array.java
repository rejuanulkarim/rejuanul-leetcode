class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num:arr){
            set.add(num);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank=1;
        for(int num: set){
            map.put(num,rank++);
        }
        for(int i=0; i < arr.length ;i++ ){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}