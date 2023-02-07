class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        left, count, ans = 0, collections.defaultdict(int), 0
        for right, val in enumerate(fruits):
            count[fruits[right]]+=1
            
            while len(count)>2:
                count[fruits[left]]-=1
                if not count[fruits[left]]:
                    count.pop(fruits[left])
                left+=1
            ans = max(ans, right-left+1)
        return ans



# class Solution:
#     def totalFruit(self, fruits: List[int]) -> int:
#         i, j, ans, mp = 0, 0, 0, {}
        
#         while j<len(fruits):
#             if fruits[j] in mp: mp[fruits[j]]+=1
#             else: mp[fruits[j]]=1
            
#             if len(mp)<=2:
#                 j+=1
#                 ans=max(ans, j-i)
#             else:
#                 mp[fruits[i]]-=1
#                 if mp[fruits[i]]==0: mp.pop(fruits[i])
#                 i+=1
#                 mp[fruits[j]]-=1
#                 if mp[fruits[j]]==0: mp.pop(fruits[j])
                
#         return ans
        


# class Solution:
#     def totalFruit(self, fruits: List[int]) -> int:
#         i, j, ans, mp = 0, 0, 0, {}
        
#         while j<len(fruits):
#             if fruits[j] in mp: mp[fruits[j]]+=1
#             else: mp[fruits[j]]=1
#             j+=1
            
#             if len(mp)<=2: ans=max(ans, j-i)
#             else:
#                 while len(mp)>2 and i<=j:
#                     mp[fruits[i]]-=1
#                     if mp[fruits[i]]==0: mp.pop(fruits[i])
#                     i+=1
        
#         return ans
        