# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# recursive
# class Solution(object):
#     def maxDepth(self, root):
#         return max(self.maxDepth(root.left), self.maxDepth(root.right))+1 if root else 0

# iterative
class Solution(object):
    def maxDepth(self, root):
        if not root:
            return 0
        q=[root]
        ans=0
        while len(q)>0:
            l=len(q)
            for i in range(l):
                node=q.pop(0)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            ans+=1
        return ans