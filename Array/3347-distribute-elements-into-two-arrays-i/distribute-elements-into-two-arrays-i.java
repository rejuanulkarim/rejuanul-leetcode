class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        int l=0,r=n-1;
        arr[l] = nums[0];
        arr[r] = nums[1];
        for(int i=2;i<n;i++){
            if(arr[l] > arr[r]){
                arr[++l] = nums[i];
            }else arr[--r] = nums[i];
        }
        int end = n-1;
        while(r < end){
            int temp= arr[r];
            arr[r] = arr[end];
            arr[end] = temp;
            r++; end--;
        }
        return arr;
    }
}