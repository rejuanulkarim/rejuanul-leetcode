class Solution:
    def gcd(self, a, b):
        while a :
            temp = a
            a = b%a
            b = temp
        return b
    def gcdSum(self, nums: list[int]) -> int:
        n = len(nums)
        prefixGcd = []
        mx = 0
        for num in nums:
            mx = max(mx,num)
            prefixGcd.append(gcd(num,mx))
        prefixGcd.sort()
        res =0
        for i in range(n//2):
            res += gcd(prefixGcd[i],prefixGcd[n-1-i])
        return res