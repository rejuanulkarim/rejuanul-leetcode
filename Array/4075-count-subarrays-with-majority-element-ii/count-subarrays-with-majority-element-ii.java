class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int cumSum =0;
        map.put(cumSum,1);
        long validLeftPoints = 0;
        long result = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                validLeftPoints += map.get(cumSum);
                cumSum +=1;
            }else{
                cumSum -= 1;
                validLeftPoints -= map.getOrDefault(cumSum,0);
            }
            int count = map.getOrDefault(cumSum,0);
            map.put(cumSum,count+1);
            result += validLeftPoints;
        }
        return result;
    }
}