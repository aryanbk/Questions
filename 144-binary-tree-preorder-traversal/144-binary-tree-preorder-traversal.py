# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


#Iterative
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        stk=[root]
        ans=[]
        while len(stk)!=0:
            node=stk.pop()
            ans.append(node.val)
            if node.right:
                stk.append(node.right)
            if node.left:
                stk.append(node.left)
        return ans
        
        
        
        
        
# recursive
# class Solution:
#     def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
#         if not root:
#             return []
#         ans =[root.val]
#         ans.extend(self.preorderTraversal(root.left))
#         ans.extend(self.preorderTraversal(root.right))
#         return ans
        