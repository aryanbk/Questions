class Solution:
    def jump(self, nums: List[int]) -> int:
        def find(ptr):
            if ptr>=len(nums):
                return float('inf')
            if ptr==len(nums)-1:
                return 0
            if memo[ptr]!=None:
                return memo[ptr]
            memo[ptr]=float('inf')
            for i in range(nums[ptr]):
                memo[ptr] = min(memo[ptr], find(1+i+ptr)+1)
            return memo[ptr]
        
        memo = [None]*len(nums)
        return find(0)
        