class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        def bk(ptr, last, sub):
            if ptr>len(nums)-1:
                if len(sub)>1:
                    ans.add(tuple(sub))
                return
            if last<=nums[ptr]:
                sub.append(nums[ptr])
                bk(ptr+1, nums[ptr], sub)
                sub.pop()
            bk(ptr+1, last, sub)
        
        ans=set()
        bk(0, -float('inf'), [])
        return ans