# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stk=[]
        while True:
            if root:
                stk.append(root)
                root=root.left
            else:
                root=stk.pop()
                k-=1
                if k==0: return root.val
                root=root.right

    
    
# Inorder
# class Solution:
#     def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
#         stk, ans = [], []
#         while True:
#             if root:
#                 stk.append(root)
#                 root=root.left
#             else:
#                 if not stk: break
#                 root=stk.pop()
#                 ans.append(root.val)
#                 if len(ans)==k: return ans[-1]
#                 root=root.right

# Recursive
# class Solution:
#     def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
#         def dfs(root):
#             if not root: return
#             if len(ino)>=k: return
#             dfs(root.left)
#             if len(ino)<k: ino.append(root.val)
#             dfs(root.right)
#         ino=[]
#         dfs(root)
#         return ino[-1]
        