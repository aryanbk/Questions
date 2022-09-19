# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        
        def fillstk(stk, root, left):
            while root:
                stk.append(root)
                if left: root=root.left
                else: root=root.right
                    
        ##########
        stkl, stkr = [], []
        fillstk(stkl, root, True)
        fillstk(stkr, root, False)
        
        while stkl and stkr and (stkl[-1]!=stkr[-1]):
            sums=stkl[-1].val + stkr[-1].val
            if sums==k: return True
            elif sums<k:
                node=stkl.pop()
                fillstk(stkl, node.right, True)
            elif sums>k:
                node=stkr.pop()
                fillstk(stkr, node.left, False)
        return False





# class Solution:
#     def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
#         ans=None
#         def inorder(root):
#             nonlocal ans
#             if not root or ans: return
#             inorder(root.left)
#             if k-root.val in ino:
#                 ans=True
#                 return
#             ino.add(root.val)
#             inorder(root.right)
#         ino=set()
#         inorder(root)
#         return ans
        