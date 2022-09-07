# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        ans=0
        def dfs(root, sm):
            if not (root.left or root.right):
                nonlocal ans
                sm = sm*10 + root.val
                ans += sm
                return
            sm = sm*10 + root.val
            if root.left:
                dfs(root.left, sm)
            if root.right:
                dfs(root.right, sm)
        
        dfs(root, 0)
        return ans
            
        