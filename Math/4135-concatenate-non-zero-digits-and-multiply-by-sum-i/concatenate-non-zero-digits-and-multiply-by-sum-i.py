class Solution:
    def sumAndMultiply(self, n: int) -> int:
        num =0
        sum =0
        base =1
        while n:
            r = n%10
            if r :
                num += r*base
                base *=10
            sum +=r
            n = n//10
        return sum * num