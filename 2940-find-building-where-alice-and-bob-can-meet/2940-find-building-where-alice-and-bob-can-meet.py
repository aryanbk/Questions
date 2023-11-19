from typing import List

class Solution:
    def leftmostBuildingQueries(self, heights: List[int], q: List[List[int]]) -> List[int]:
        stack = []
        result = [-1] * len(heights)

        # Finding rightmost indices where heights[j] > heights[i] for each index i
        for i in range(len(heights)):
            while stack and heights[i] > heights[stack[-1]]:
                index = stack.pop()
                result[index] = i
            stack.append(i)

        # Processing queries
        ans = []
        for a, b in q:
            if a == b or heights[max(a, b)] > heights[min(a, b)]:
                ans.append(max(a, b))
            elif result[a] == -1 or result[b] == -1:
                ans.append(-1)
            else:
                mx = max(result[a], result[b])
                while mx != -1 and not (heights[mx] > heights[a] and heights[mx] > heights[b]):
                    mx = result[mx]
                ans.append(mx)

        return ans


# class Solution:
#     def leftmostBuildingQueries(self, heights: List[int], q: List[List[int]]) -> List[int]:
#         stack = [] 
#         result = [-1] * len(heights) 

#         for i in range(len(heights)):
#             while stack and heights[i] > heights[stack[-1]]:
#                 index = stack.pop() 
#                 result[index] = i  

#             stack.append(i)  
#         h = len(heights)
#         n = len(q)
#         ans = [-1]*(n)
#         for i in range(n):
#             a, b = q[i][0], q[i][1]
#             if a==b:
#                 ans[i] = a
#             elif heights[max(a, b)] > heights[min(a, b)]:
#                 ans[i] = max(a, b)
#             elif result[a]==-1 or result[b]==-1:
#                 continue
#             else:
#                 mx = max(result[a], result[b])
#                 while (not (heights[mx] > heights[a] and heights[mx] > heights[b])) and mx != -1:
#                     mx = result[mx]
#                 ans[i] = mx
                
#         return ans
                
        
        