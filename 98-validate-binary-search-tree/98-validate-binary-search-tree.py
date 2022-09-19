# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode], mini=-1*(1<<32), maxi=1<<32) -> bool:
        if not root: return True
        if root.val<=mini: return False
        if root.val>=maxi: return False
        return self.isValidBST(root.left, mini, root.val) and self.isValidBST(root.right, root.val, maxi)
    