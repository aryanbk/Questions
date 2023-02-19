# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        dir, q, ans = True, [root], []
        while len(q)>0:
            sub = []
            for _ in range(len(q)):
                node=q.pop(0)
                sub.append(node.val)
                if node.left: q.append(node.left)
                if node.right : q.append(node.right)
            if dir==False: sub.reverse()
            ans.append(sub)
            dir = not dir
        return ans


                
# class Solution:
#     def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
#         if not root: return []
#         dir, q, ans = True, [root], []
#         while len(q)>0:
#             l=len(q)
#             sub=[]
#             for i in range(l):
#                 node=q.pop(0)
#                 sub.append(node.val)
#                 if node.left: q.append(node.left)
#                 if node.right : q.append(node.right)
#             if dir==False: sub.reverse()
#             ans.append(sub)
#             dir=not dir
#         return ans