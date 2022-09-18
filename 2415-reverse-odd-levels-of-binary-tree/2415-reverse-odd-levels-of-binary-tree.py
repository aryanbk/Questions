# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def swap(r1, r2, odd):
            if not r1: return
            if odd:
                temp=r1.val
                r1.val=r2.val
                r2.val=temp
            swap(r1.left, r2.right, not odd)
            swap(r1.right, r2.left, not odd)
        swap(root.left, root.right, True)
        return root
                

# class Solution:
#     def reverseOddLevels(self, root: Optional[TreeNode], l=0) -> Optional[TreeNode]:
#         q, odd = [root], False
#         while q:
#             lq, sub = len(q), []
#             for _ in range(lq):
#                 node=q.pop(0)
#                 if odd: sub.append(node)
#                 if node.left: q.append(node.left)
#                 if node.right: q.append(node.right)
#             if odd:
#                 i, j = 0, len(sub)-1
#                 while i<j:
#                     temp=sub[i].val
#                     sub[i].val = sub[j].val
#                     sub[j].val=temp
#                     i+=1
#                     j-=1
#             odd = not odd
#         return root
        