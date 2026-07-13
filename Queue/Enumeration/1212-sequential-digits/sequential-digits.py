class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        res = []
        q = [1,2,3,4,5,6,7,8,9]
        while q :
            num = q.pop(0)
            if num >= low:
                res.append(num)
            last = num%10
            num = num*10 +(last+1)
            if last < 9 and num <= high:
                q.append(num)
        return res