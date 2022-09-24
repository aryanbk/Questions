# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def dfs(root, sm, path):
            if not root:
                return
            path.append(root.val)
            if not root.left and not root.right and sm==root.val:
                ans.append(path.copy())
            else:
                dfs(root.left, sm-root.val, path)
                dfs(root.right, sm-root.val, path)
            path.pop()
        ans=[]
        dfs(root, targetSum, [])
        return ans
    


# this won't work

# class Solution:
#     def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
#         def dfs(root, sm, path):
#             if not root:
#                 # len(path)>0 to bypass the null node and tsum=0 edgecase
#                 if sm==0 and len(path)>0:
#                     ans.append(path.copy())
#                     return True
#                 return sm==0
#             path.append(root.val)
#             l = dfs(root.left, sm-root.val, path)
#             if not l:
#                 dfs(root.right, sm-root.val, path)
#             path.pop()
#         ans=[]
#         dfs(root, targetSum, [])
#         return ans