# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def reverseOddLevels(self, root: Optional[TreeNode], l=0) -> Optional[TreeNode]:
        q, odd = [root], False
        while q:
            lq, sub = len(q), []
            for _ in range(lq):
                node=q.pop(0)
                if odd: sub.append(node)
                if node.left: q.append(node.left)
                if node.right: q.append(node.right)
            if odd:
                i, j = 0, len(sub)-1
                while i<j:
                    temp=sub[i].val
                    sub[i].val = sub[j].val
                    sub[j].val=temp
                    i+=1
                    j-=1
            odd = not odd
        return root