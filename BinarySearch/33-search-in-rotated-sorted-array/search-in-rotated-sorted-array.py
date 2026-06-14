class Solution:
    def search(self, nums: List[int], target: int) -> int:
        #find the minimun number in sorted list
        l=0;r=len(nums)-1
        while l<r:
            m = l+(r-l)//2
            if nums[r]<nums[m]:
                l = m+1
            else: r=m
        #search first half
        first = self.searchNum(nums,target,0,l-1) # l-1 because nums[l] is mininum number 
        if first != -1 : return first
        #search in 2nd half
        return self.searchNum(nums,target,l,len(nums)-1)
    def searchNum(self,nums,target,l,r):
        while l <= r:
            m = l+(r-l)//2
            if nums[m] == target: return m
            if target < nums[m]:
                r =m-1
            else: l =m+1
        return -1
    
        