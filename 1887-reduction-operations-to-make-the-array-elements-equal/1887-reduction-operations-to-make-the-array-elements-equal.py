class Solution:
    def reductionOperations(self, nums):
        c = Counter(nums)
        keys = sorted(c.keys(), reverse=True)
        operations = 0
        count = 0

        for i in range(1, len(keys)):
            count += c[keys[i - 1]]
            operations += count

        return operations



# wrong attemps
# 
# class Solution:
#     def reductionOperations(self, nums: List[int]) -> int:
#         c = Counter(nums)
#         n = list(c.items())
#         n.sort(key=lambda x: (x[0], x[1]))
#         print(n, len(nums))
#         suff = 0
#         ans  = 0
#         for i in range(len(n)-1, 0, -1):
#             print(i)
#             suff += n[i][1]
#         return suff
        
        
        
#         def all_diff():
#             f = h[0][0]
#             for i in h:
#                 if i[0] != f:
#                     return True
#             return False
        
#         step = 0
        
#         h = [(-nums[i], i) for i in range(len(nums))]
#         heapify(h)
        
#         while all_diff():
            
#             large, idx = heappop(h)
#             nx_idx = 0
#             while large == h[nx_idx][0]:
#                 nx_idx+=1
#             next_large = h[nx_idx][0]
#             heappush(h, (next_large, idx))
#             step+=1
        
#         return step