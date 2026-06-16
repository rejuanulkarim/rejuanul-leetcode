class Solution {
    public String frequencySort(String s) {


        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }


        // PriorityQueue<Character> q = new PriorityQueue<>((a, b) -> {
        // int diff = map.get(b) - map.get(a);
        // return diff != 0 ? diff : a - b;
        // });
        // for(char ch:s.toCharArray()) q.add(ch);

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)-> map.get(b)-map.get(a)); 
        pq.addAll(map.keySet());


        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char ch = pq.poll();
            for(int i=0;i<map.get(ch);i++) sb.append(ch);
        }


        return sb.toString();
    }
}
