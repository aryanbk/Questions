class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        c1, c2 = Counter(nums1), Counter(nums2)
        ans = []
        for k,v in c1.items():
            for i in range(min(v, c2.get(k, 0))):
                ans.append(k)
        return ans