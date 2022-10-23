class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        target = sum(nums)
        if target%2==1:
            return False
        target = target//2
        
        def helper(ptr, target):
            if target==0:
                return True
            if ptr>=len(nums) or target<0:
                return False
            if memo[ptr][target]==-1:
                memo[ptr][target] = int(helper(ptr+1, target) or helper(ptr+1, target-nums[ptr]))
            return memo[ptr][target]==1
            
        memo = [[-1]*(target+1) for _ in range(len(nums))]
        return helper(0, target)