# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root: return None
        elif root.val == key:
            if not root.left: return root.right
            elif not root.right: return root.left
            else:
                temp=root.left
                while temp.right: temp=temp.right
                temp.right=root.right
                return root.left
        elif root.val>key: root.left = self.deleteNode(root.left, key)
        else: root.right=self.deleteNode(root.right, key)
        return root
                