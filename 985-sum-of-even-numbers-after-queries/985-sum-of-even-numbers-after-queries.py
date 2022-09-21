class Solution:
    def sumEvenAfterQueries(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        sm=0
        for i in nums:
            if i%2==0: sm += i
        ans=[]
        for i in range(len(queries)):
            n, q = nums[queries[i][1]]%2==0, queries[i][0]%2==0
            if n and q:sm += queries[i][0]
            elif not n and not q: sm += nums[queries[i][1]]+queries[i][0]
            elif n and not q: sm -= nums[queries[i][1]]
            nums[queries[i][1]] += queries[i][0]
            ans.append(sm)
        return ans