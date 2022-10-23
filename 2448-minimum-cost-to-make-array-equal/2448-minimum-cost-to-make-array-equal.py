class Solution:
    def minCost(self, nums: List[int], cost: List[int]) -> int:
        arr = sorted([(nums[i], cost[i]) for i in range(len(cost))])
        sumt, curr = sum(cost), 0
        i=0
        while i<len(cost):
            curr += arr[i][1]
            if curr>sumt//2:
                median=arr[i][0]
                break
            i+=1
        return sum([abs(arr[x][0] - median)*arr[x][1] for x in range(len(cost))])