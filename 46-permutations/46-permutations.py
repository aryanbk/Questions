class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        def swap(i, j):
            temp=nums[i]
            nums[i]=nums[j]
            nums[j]=temp
        
        def permute(ptr):
            if ptr>=len(nums):
                ans.append(nums[:])
            else:
                for p2 in range(ptr, len(nums)):
                    swap(ptr, p2)
                    permute(ptr+1)
                    swap(ptr, p2)
                
        
        ans=[]
        permute(0)
        return ans





# class Solution:
#     def permute(self, nums: List[int]) -> List[List[int]]:
#         def dfs(ptr, sub, mp):
#             if ptr>=len(nums):
#                 ans.append(sub.copy())
#                 return
#             for i in range(0, len(nums)):
#                 if mp[i]:
#                     sub.append(nums[i])
#                     mp[i]=False
#                     dfs(ptr+1, sub, mp)
#                     mp[i]=True
#                     sub.pop()
        
#         ans=[]
#         dfs(0, [], [True]*len(nums))
#         return ans
        