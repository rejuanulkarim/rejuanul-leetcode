class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res  = 0 ;
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort(null);
        int preKey =0;
        for(Integer key:keys){
            res += Math.min(key-preKey, map.get(key));
            preKey = key;
        }
        return res;
    }
}