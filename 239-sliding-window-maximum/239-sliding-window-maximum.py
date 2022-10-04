class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        dq, l, ans= deque(), 0, []
        
        for r, val in enumerate(nums):
            while dq and dq[-1]<val:
                dq.pop()
            dq.append(val)
            
            if r-l+1==k:
                ans.append(dq[0])
                if dq[0]==nums[l]:
                    dq.popleft()
                l+=1
                
        return ans



# class Solution:
#     def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
#         dq, i, j, ans = deque(), 0, 0, []
#         while(j<len(nums)):
#             while dq and dq[-1]<nums[j]: dq.pop()
#             dq.append(nums[j])
#             if j-i+1==k:
#                 ans.append(dq[0])
#                 if nums[i]==dq[0]: dq.popleft()
#                 i+=1
#             j+=1
#         return ans