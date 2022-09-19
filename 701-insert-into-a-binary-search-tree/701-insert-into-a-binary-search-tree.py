# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int , left=True) -> Optional[TreeNode]:
        if not root: root = TreeNode(val)
        elif root.val>val: root.left = self.insertIntoBST(root.left, val)
        elif root.val < val: root.right = self.insertIntoBST(root.right, val)
        return root


# class Solution:
#     def insertIntoBST(self, root: Optional[TreeNode], val: int , prev=None, left=True) -> Optional[TreeNode]:
#         if not root:
#             if not prev: return TreeNode(val)
#             if left:
#                 prev.left=TreeNode(val)
#                 return prev.left
#             else:
#                 prev.right = TreeNode(val)
#                 return prev.right
#         if root.val>val:
#             root.left = self.insertIntoBST(root.left, val , root, True)
#             return root
#         elif root.val < val:
#             root.right = self.insertIntoBST(root.right, val , root, False)
#             return root
        