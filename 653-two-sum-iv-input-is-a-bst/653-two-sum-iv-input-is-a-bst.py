# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        ans=None
        def inorder(root):
            nonlocal ans
            if not root or ans: return
            inorder(root.left)
            if k-root.val in ino:
                ans=True
                return
            ino.add(root.val)
            inorder(root.right)
        ino=set()
        inorder(root)
        return ans