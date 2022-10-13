"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        def dfs(node):
            if node and node.val not in adrs:
                n=Node(node.val)
                adrs[n.val]=n
                for i in node.neighbors:
                    dfs(i)
        
        def dfs2(node):
            if len(adrs[node.val].neighbors) != len(node.neighbors):
                for i in node.neighbors:
                    adrs[node.val].neighbors.append(adrs[i.val])
                for i in node.neighbors:
                    dfs2(i)
                

        if node:
            adrs={}
            dfs(node)
            dfs2(node)
            return adrs[node.val]