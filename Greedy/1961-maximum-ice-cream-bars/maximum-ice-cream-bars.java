class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for(int coin: costs){
            if(coins < coin) return res;
            coins -= coin;
            res++;
        }
        return res;
    }
}