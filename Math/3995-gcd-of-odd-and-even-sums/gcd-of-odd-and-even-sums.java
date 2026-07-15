/*
class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddSum = 0, evenSum =0;
        for(int i=1;i<= 2*n;i++){
            if(i%2 == 0){
                evenSum += i;
            }else{
                oddSum += i;
            }
        }
        while(oddSum != 0){
            int temp = oddSum;
            oddSum = evenSum % oddSum;
            evenSum = temp;
        }
        return evenSum;
    }
}
*/
// /* 

class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddSum =0, evenSum =0;
        for(int i=0;i<= 2*n;i+=2){
            evenSum +=i; 
        }
        oddSum = evenSum - n;
        while(oddSum != 0){
            int temp = oddSum;
            oddSum = evenSum % oddSum;
            evenSum = temp;
        }
        return evenSum;
    }
}
// */

/*

class Solution {
    public int gcdOfOddEvenSums(int n) {
    }
    }

 */
