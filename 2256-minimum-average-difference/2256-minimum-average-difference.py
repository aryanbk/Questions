class Solution:
    def minimumAverageDifference(self, nums: List[int]) -> int:
        l = len(nums)
        sumt = [0 for i in range(l)]
        for i in range(l-2, -1, -1):
            sumt[i] += nums[i+1] + sumt[i+1]
        
        curr, ans, mini = 0, float('inf'), -1
        for i in range(l):
            curr+=nums[i]
            curr_ans = abs((curr//(i+1)) - (sumt[i]//(l-i-1))) if l-i-1>0 else abs((curr//(i+1)))
            if curr_ans < ans:
                mini = i
                ans = curr_ans
        
        return mini