# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pruneTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(root):
            if not root:
                return False
            l=dfs(root.left)
            r=dfs(root.right)
            if l==False:
                root.left=None
            if r==False:
                root.right=None
            return l or r or root.val
        
        return None if dfs(root)==False else root
        