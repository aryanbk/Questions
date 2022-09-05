# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        q = Queue()
        q.put(root)
        ans=[]
        while q.qsize()>0:
            sublist=[]
            l=q.qsize()
            for i in range(l):
                node = q.get()
                sublist.append(node.val)
                if node.left:
                    q.put(node.left)
                if node.right:
                    q.put(node.right)
            ans.append(sublist)
        return ans