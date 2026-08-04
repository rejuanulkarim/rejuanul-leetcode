/*
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int low = nums[0];
        for(int i = 1;i<nums.length;i++){
            while(++low < nums[i]){
                list.add(low);
            }
        }
        return list;
    }
}
*/

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int low = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            low = (num < low)? num:low;
            max = (max > num)? max: num; 
            set.add(num);
        }
        while(++low < max) if(!set.contains(low)) list.add(low);
        return list;
    }
}