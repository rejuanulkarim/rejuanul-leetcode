class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        Character[] arr = new Character[s.length()];
        for(int i=0;i<s.length();i++){
            char key = s.charAt(i);
            map.put(key,map.getOrDefault(key,0)+1);
            arr[i] = key;
        }
        Arrays.sort(arr,(a,b)->{
        int diff = map.get(b) - map.get(a);
        return (diff != 0)? diff: a-b;
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
