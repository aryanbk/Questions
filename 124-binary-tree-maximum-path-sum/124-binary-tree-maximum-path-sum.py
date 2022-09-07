# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        ans=root.val
        def dfs(root):
            if not root:
                return 0
            nonlocal ans
            l = dfs(root.left)
            r = dfs(root.right)
            res = max(l,r,0)+root.val
            ans = max(ans, res, root.val+l+r, root.val)
            return res
        
        dfs(root)
        return ans