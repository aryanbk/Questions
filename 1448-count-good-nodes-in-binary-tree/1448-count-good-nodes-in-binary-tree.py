# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode, maxi=-10**4-1) -> int:
        if not root:
            return 0
        return int(root.val>=maxi) + self.goodNodes(root.left, max(root.val, maxi)) + self.goodNodes(root.right, max(root.val, maxi))
        