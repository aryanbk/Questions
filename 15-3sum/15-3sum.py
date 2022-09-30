class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        i=0
        ans=[]
        l=len(nums)
        while i<l:
            lo, hi = i+1, l-1
            while lo<hi:
                s=nums[i]+nums[lo]+nums[hi]
                if s==0:
                    ans.append([nums[i], nums[lo], nums[hi]])
                    p=lo
                    while lo<l and nums[lo]==nums[p]: lo+=1
                    p=hi
                    while hi>=0 and nums[hi]==nums[p]: hi-=1
                elif s>0: hi-=1
                else: lo+=1
            p=i
            while i<l and nums[p]==nums[i]: i+=1
        return ans
                    
                    
        