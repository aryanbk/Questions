class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        s=set(arr)
        i=1
        while k:
            if i not in s:
                k-=1
            i+=1
        return i-1