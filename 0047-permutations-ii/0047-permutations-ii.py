class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def find(curr, taken):
            if len(curr)==len(nums):
                ans.add(tuple(curr))
                return
            for i in range(len(nums)):
                if not taken[i]:
                    taken[i]=True
                    curr.append(nums[i])
                    find(curr, taken)
                    curr.pop()
                    taken[i]=False
        
        ans = set()
        find([], [False for i in nums])
        return ans