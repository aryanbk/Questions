class Solution:
    def jump(self, nums: List[int]) -> int:
        def find(ptr):
            if ptr==n-1: return 0
            if memo[ptr]==None:
                memo[ptr]=float('inf')
                for i in range(min(nums[ptr], n-ptr-1)):
                    memo[ptr] = min(memo[ptr], find(1+i+ptr)+1)
            return memo[ptr]
        
        n = len(nums)
        memo = [None]*n
        return find(0)
        