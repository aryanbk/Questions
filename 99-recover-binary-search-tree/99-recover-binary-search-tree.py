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
        
        one, two, three, prev = None, None, None, None
        inord(root)
        if three:
            temp=one.val
            one.val=three.val
            three.val=temp
        else:
            temp=one.val
            one.val=two.val
            two.val=temp
            
        