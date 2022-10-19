class Solution:
    def minMoves(self, target: int, maxDoubles: int) -> int:
        step=0
        while target>1 and maxDoubles:
            step += 2 if target%2 else 1
            target //= 2
            maxDoubles -= 1
        return step+target-1
        
# class Solution:
#     def minMoves(self, target: int, maxDoubles: int) -> int:
#         def dfs(num, maxd, step):
#             nonlocal target
#             if num>target or maxd<0:
#                 return math.inf
#             if num==target:
#                 return step
            
#             return min(dfs(num+1, maxd, step+1), dfs(num*2, maxd-1, step+1))
        
#         return dfs(1, maxDoubles, 0)
        