# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        if not root: return
        if root.left:
            ptr=root.left
            while ptr.right:
                ptr=ptr.right
            ptr.right=root.right
            root.right=root.left
            root.left=None
        self.flatten(root.right)
        