# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self, root):
        return 1+self.dfs(root.left) if root else 0
    def countNodes(self, root: Optional[TreeNode]) -> int:
        if not root: return 0
        l=self.dfs(root.left)
        r=self.dfs(root.right)
        return 1+self.countNodes(root.right) + ((1<<l)-1 if l==r else self.countNodes(root.left))
        