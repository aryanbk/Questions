# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def addOneRow(self, root: Optional[TreeNode], val: int, depth: int) -> Optional[TreeNode]:
        def addnode(root, val, depth):
            if root and depth==1:
                root.left = TreeNode(val, root.left, None)
                root.right = TreeNode(val, None, root.right)
            elif root and depth>1:
                root.left = addnode(root.left, val, depth-1)
                root.right = addnode(root.right, val, depth-1)
            return root
        
        newroot = TreeNode(-1, root)
        return addnode(newroot, val, depth).left

        