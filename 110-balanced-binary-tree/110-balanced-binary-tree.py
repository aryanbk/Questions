# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def dfs(root):
            if not root:
                return 0
            l,r=dfs(root.left),dfs(root.right)
            if abs(l-r)>1 or l==-1 or r==-1:
                return -1
            return max(l,r)+1
        return True if dfs(root)>=0 else False

# class Solution:
#     def isBalanced(self, root: Optional[TreeNode]) -> bool:
#         ans=True
#         def dfs(root):
#             if not root:
#                 return 0
#             nonlocal ans
#             l,r=dfs(root.left),dfs(root.right)
#             if abs(l-r)>1 and ans:
#                 ans=False
#             return max(l,r)+1
#         dfs(root)
#         return ans