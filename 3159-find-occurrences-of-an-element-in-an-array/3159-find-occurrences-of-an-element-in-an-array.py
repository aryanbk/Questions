class Solution:
    def occurrencesOfElement(self, nums: List[int], q: List[int], x: int) -> List[int]:
        mp = {}
        oc = 1
        for i in range(len(nums)):
            if nums[i]==x:
                mp[oc] = i
                oc += 1
            
        return [mp.get(i, -1) for i in q]