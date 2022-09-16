# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        up, q, st = {}, [root], None
        while q:
            l=len(q)
            for _ in range(l):
                node=q.pop(0)
                if node.val==start:
                    st=node
                if node.left:
                    q.append(node.left)
                    up[node.left.val]=node
                if node.right:
                    q.append(node.right)
                    up[node.right.val]=node
        q.append(st)
        ans, s = 0,set()
        while q:
            l=len(q)
            for _ in range(l):
                node=q.pop(0)
                s.add(node.val)
                if node.left and node.left.val not in s: q.append(node.left)
                if node.right and node.right.val not in s: q.append(node.right)
                if node.val in up and up[node.val].val not in s: q.append(up[node.val])
            ans+=1
        return ans-1