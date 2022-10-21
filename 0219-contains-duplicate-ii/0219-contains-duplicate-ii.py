class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        l=0
        s=set()
        for r in range(0, len(nums)):
            s.add(nums[r])
            if r-l+1 > k:
                s.remove(nums[l])
                l+=1
            if len(s)!=r-l+1:
                return True
        return False