# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        q, ans = [[root, 1]], 1
        while len(q)!=0:
            l, mini, maxi= len(q), q[0][1], -1,
            for i in range(l):
                node, num = q.pop(0)
                maxi = num
                if node.left: q.append([node.left, 2*num - 1])
                if node.right: q.append([node.right, 2*num])
            ans=max(ans, maxi-mini+1)
        return ans
            