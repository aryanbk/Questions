# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:    
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if not root:
            return False
        return self.isSame(root, subRoot) or self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)

    def isSame(self, root, subroot):
        if not root and not subroot:
            return True
        if (root and not subroot) or (subroot and not root):
            return False
        return root.val==subroot.val and self.isSame(root.left, subroot.left) and self.isSame(root.right, subroot.right)