# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Morris Traversal
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        ans, ptr = [], root
        while ptr:
            if not ptr.left:
                ans.append(ptr.val)
                ptr=ptr.right
            else:
                prev=ptr.left
                while prev.right and prev.right!=ptr:
                    prev=prev.right
                if not prev.right:
                    prev.right=ptr
                    ptr=ptr.left
                else:
                    prev.right=None
                    ans.append(ptr.val)
                    ptr=ptr.right
        return ans

    

# Iterative
# class Solution:
#     def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
#         stk,ans=[],[]
#         while True:
#             if root:
#                 stk.append(root)
#                 root=root.left
#             else:
#                 if len(stk) is 0:
#                     return ans
#                 root=stk.pop()
#                 ans.append(root.val)
#                 root=root.right
        
        
        
# Recursive
# class Solution:
#     def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
#         if not root:
#             return []
#         res=self.inorderTraversal(root.left)
#         res.append(root.val)
#         res.extend(self.inorderTraversal(root.right))
#         return res
        