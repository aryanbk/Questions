# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        stk,ans=[],[]
        while True:
            if root:
                stk.append(root)
                root=root.left
            else:
                if len(stk) is 0:
                    return ans
                root=stk.pop()
                ans.append(root.val)
                root=root.right
        
        
        
# class Solution:
#     def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
#         if not root:
#             return []
#         res=self.inorderTraversal(root.left)
#         res.append(root.val)
#         res.extend(self.inorderTraversal(root.right))
#         return res