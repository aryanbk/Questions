# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if (root.val-p.val)*(root.val-q.val)<=0: return root
        return self.lowestCommonAncestor(root.left, p, q) if p.val<root.val else self.lowestCommonAncestor(root.right, p, q)