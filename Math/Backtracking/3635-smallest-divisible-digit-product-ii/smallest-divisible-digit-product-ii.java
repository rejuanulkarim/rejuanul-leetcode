class Solution {
    public String smallestNumber(String num, long t) {
        int n = num.length();
        long orgT = t;
        int[] primes = {2,3,5,7};
        for(int prime:primes){
            while(t % prime == 0) t /= prime;
        }
        if(t != 1) return "-1";
        // Precompute remainigFactor
        long[] remainingFactor = new long[n+1];
        remainingFactor[0] = orgT;
        for(int i=0;i<n;i++){
            int digit = num.charAt(i) -'0';
            if(digit == 0) break;
            remainingFactor[i+1] = remainingFactor[i]/gcd(digit,remainingFactor[i]);
        }
        int zeroIdx = num.indexOf('0');
        if(zeroIdx == -1){
            if(remainingFactor[n]==1) return num;
            zeroIdx = n-1;
        }
        for(int i = zeroIdx;i>=0;i--){
            long required = remainingFactor[i];
            int freeSlots = n-1-i;

            int start = (i == zeroIdx && num.charAt(i) == '0')? 1: num.charAt(i) - '0' + 1;

            for (int digit = start; digit <= 9; digit++) {
                long furtherRequired = required/gcd(required,digit);
                String requiredNumber = freeSlotsFiller(furtherRequired,freeSlots);
                if(requiredNumber.length() == freeSlots){
                    // return num.substring(0,i)+ digit + requiredNumber;
                    return num.substring(0, i) + (char)('0' + digit) + requiredNumber;
                }
            }
        }
        return freeSlotsFiller(orgT,n+1);
    }
    String freeSlotsFiller(long required, long length){
        StringBuilder sb = new StringBuilder();
        for(int digit =9;digit >=2;digit--){
            while(required%digit == 0){
                sb.append(digit);
                required/=digit;
            }
        }
        while(sb.length() < length){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
    long gcd(long a,long b){
        while(b != 0){
            long temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}