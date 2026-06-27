class Solution {
    public int maximumLength(int[] nums) {
        //   Array/subset
        HashMap<Integer, Integer> map  = new HashMap<>();
        for(int num: nums){
            int freq = map.getOrDefault(num,0);
            map.put(num,freq+1);
        }
        int one = map.getOrDefault(1,0);

        int res = (one%2 == 0)? one-1:one;  // special case for 1 

        for(int key:map.keySet()){
            int sqrt = (int)Math.sqrt(key); // check alredy count or not.
            if(key == 1 && map.containsKey(sqrt)) continue; // 1 alredy calculat.

            int count = 0;
            int fq = map.getOrDefault(key,0);
            while(fq > 1){
                count +=2;
                key = key*key;
                fq = map.getOrDefault(key,0);
            }
            if(fq == 1) count++;
            else count--;
            res = Math.max(res,count);
        }
        return res;
    }
}