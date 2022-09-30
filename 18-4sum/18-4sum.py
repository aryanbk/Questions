class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        l, ans, i = len(nums), [], 0
        while i<l:
            j=i+1
            while j<l:
                lo, hi = j+1, l-1
                while lo<hi and hi>j:
                    sm=nums[i]+nums[j]+nums[lo]+nums[hi]-target
                    if sm>0: hi-=1
                    elif sm<0: lo+=1
                    else:
                        ans.append([nums[i], nums[j], nums[lo], nums[hi]])
                        p=nums[lo]
                        while lo<l and nums[lo]==p: lo+=1
                        p=nums[hi]
                        while hi>j and nums[hi]==p: hi-=1
                p=nums[j]
                while j<l and p==nums[j]: j+=1
            p=nums[i]
            while i<l and nums[i]==p: i+=1
            
        return ans