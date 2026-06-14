class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l =0; r= len(nums)-1
        first = -1
        while l<=r:
            m = l+(r-l)//2
            if nums[m] == target: first = m
            if(target <= nums[m]):
                r= m-1
            else: l =m+1
        if first == -1: return [-1,-1]
        l=first; r = len(nums)-1
        last = -1
        while l<=r:
            m = l+(r-l)//2
            if nums[m] == target: last = m
            if(target >= nums[m]):
                l =m+1
            else: r=m-1
        return [first,last]
        