class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        mini=10**4+1
        minnum=10**4+1
        nums.sort()
        for i,iv in enumerate(nums):
            a, b = i+1, len(nums)-1
            while a<b:
                sumt=iv+nums[a]+nums[b]
                if abs(sumt-target)<mini:
                    mini=abs(sumt-target)
                    minnum=sumt
                if sumt<target: a+=1
                elif sumt>target: b-=1
                else: return target
        return minnum