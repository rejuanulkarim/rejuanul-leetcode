/*
class Solution {
    int gcd(int a, int b){
        while(a!=0){
            int temp = a;
            a = b%a;
            b = temp;
        }
        return b;
    }
    public int[] gcdValues(int[] nums, long[] queries) {
        int n = nums.length;
        long [] gcdPairs = new long[n*((n-1)/2 +1)];
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                gcdPairs[k++] = gcd(nums[i],nums[j]);
            }
        }
        Arrays.sort(gcdPairs,0,k);
        int len = queries.length;
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            int idx =  (int)queries[i];
            res[i] = (int)gcdPairs[idx];
        }
        return res;
    }
}
*/
class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n = nums.length;
        int maxVal = Integer.MIN_VALUE;
        for(int num:nums){
            maxVal = Math.max(maxVal,num);
        }
        int [] freq = new int[maxVal+1];
        for(int i =0;i<n;i++){
            int num = nums[i];
            for(int j=1;j*j <= num;j++){
                if(num% j == 0){
                    freq[j]++;
                    if(num/j != j) freq[num/j]++;
                }
            }
        }
        long [] pairWithGcd = new long[maxVal+1];
        for(int g = maxVal;g >=1;g--){
            long count= freq[g];
            // nC2
            pairWithGcd[g] = count * (count-1)/2;
            //correction time
            for(int m = 2*g;m<=maxVal;m+=g){
                pairWithGcd[g] -= pairWithGcd[m];
            }
        }
        long [] prefixCountGcd = new long[maxVal+1];
        for(int g=1;g<=maxVal;g++){
            prefixCountGcd[g] = prefixCountGcd[g-1] + pairWithGcd[g];
        }
        int [] res = new int[queries.length];int k =0;
        for(long idx:queries){
            int l=1;
            int r = maxVal;
            int temp =1;
            while(l<=r){
                int mid_gcd = l+(r-l)/2;
                if(prefixCountGcd[mid_gcd]>idx){
                    temp = mid_gcd;
                    r = mid_gcd-1;
                }else{
                    l= mid_gcd+1;
                }
            }
            res[k++] = temp;
        }
        return res;
    }
}
