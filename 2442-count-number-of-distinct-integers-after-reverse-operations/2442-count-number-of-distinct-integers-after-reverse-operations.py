class Solution:
    def countDistinctIntegers(self, nums: List[int]) -> int:
        s=set()
        for i in range(len(nums)):
            s.add(nums[i])
            s.add(int(str(nums[i])[::-1]))
        return len(s)