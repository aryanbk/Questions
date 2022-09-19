# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def bstFromPreorder(self, pre: List[int]) -> Optional[TreeNode]:
        def build(ub):
            nonlocal ptr
            if ptr>=len(pre) or pre[ptr]>ub: return
            node=TreeNode(pre[ptr])
            ptr+=1
            node.left=build(node.val)
            node.right=build(ub)
            return node
        ptr=0
        return build(1001)
            
            



# using stack - largest element to the right
# O(n) extra space
# O(n) time

# class Solution:
#     def bstFromPreorder(self, pro: List[int]) -> Optional[TreeNode]:

#         def dfs(st, end):
#             if st>end: return None
#             node=TreeNode(pro[st])
#             if st==end: return node
#             leftend = mp[st]-1 if mp[st]!=st else end
#             node.left=dfs(st+1, leftend)
#             node.right = dfs(leftend+1, end)
#             return node
        
#         mp, stk = [0]*len(pro), []
#         for i in range(len(pro)-1, -1, -1):
#             while stk and stk[-1][0]<pro[i]: 
#                 stk.pop()
#             if len(stk)==0: mp[i]=i
#             else: mp[i]=stk[-1][1]
#             stk.append([pro[i], i])
#         return dfs(0, len(pro)-1)
        