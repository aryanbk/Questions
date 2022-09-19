# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        
        def inord(root):
            nonlocal one,two,three,prev
            if not root: return
            inord(root.left)
            if prev and root.val<prev.val:
                if not one:
                    one=prev
                    two=root
                else:
                    three=root
            prev=root
            inord(root.right)
        
        def swap(r1, r2):
            temp=r1.val
            r1.val=r2.val
            r2.val=temp
        
        one, two, three, prev = None, None, None, None
        inord(root)
        if three: swap(one, three)
        else: swap(one, two)
            
        