class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        heapify(nums)
        return [heappop(nums) for i in range(len(nums))]


# class Solution:
#     def sortArray(self, nums: List[int]) -> List[int]:
        
#         def merge(a, b):
#             n, m = len(a), len(b)
#             ans = []
            
#             i = j = 0
            
#             while i<n and j<m:
#                 if a[i]<=b[j]:
#                     ans.append(a[i])
#                     i+=1
#                 else:
#                     ans.append(b[j])
#                     j+=1
#             while i<n:
#                 ans.append(a[i])
#                 i+=1
#             while j<m:
#                 ans.append(b[j])
#                 j+=1
#             return ans
        
#         def divide(l):
#             if len(l)<=1:
#                 return l
#             first, last = divide(l[len(l)//2:]), divide(l[:len(l)//2])
            
#             return merge(first, last)
            
#         return divide(nums)