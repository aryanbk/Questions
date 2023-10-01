# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        q=[root]
        ans=[]
        while q:
            n = None
            for _ in range(len(q)):
                n = q.pop(0)
                if n.left:
                    q.append(n.left)
                if n.right:
                    q.append(n.right)
            ans.append(n.val)
        return ans
            