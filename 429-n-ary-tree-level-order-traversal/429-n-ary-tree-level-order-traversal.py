"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []
        q = deque()
        q.append(root)
        ans=[]
        while len(q)>0:
            l=len(q)
            sublist=[]
            for i in range(l):
                node=q.popleft()
                sublist.append(node.val)
                for j in node.children:
                    q.append(j)
            ans.append(sublist)
        return ans