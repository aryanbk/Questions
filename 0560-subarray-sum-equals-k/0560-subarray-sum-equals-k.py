class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        ans=sumt=0
        hm=defaultdict(int)
        hm[0]+=1
        for i in nums:
            sumt+=i
            ans+=hm[sumt-k]
            hm[sumt]+=1
        return ans