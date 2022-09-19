# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def dfs(root):
            if not root: return
            if len(ino)>=k: return
            dfs(root.left)
            if len(ino)<k: ino.append(root.val)
            dfs(root.right)
        ino=[]
        dfs(root)
        return ino[-1]
            
        