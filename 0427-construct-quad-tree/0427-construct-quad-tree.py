"""
# Definition for a QuadTree node.
class Node:
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight
"""

class Solution:
    def construct(self, grid: List[List[int]]) -> 'Node':
        def make(i, j, x, y, n):
            if i<j and x<y:
                sumt = sum([sum(r[x:y]) for r in grid[i:j]])
                if sumt==0 or sumt==(j-i)*(y-x):
                    return Node(sumt//((j-i)*(y-x)) , 1, None, None, None, None)
                
                ij, xy = i+(j-i)//2, x+(y-x)//2
                return Node(1, 0, make(i, ij, x, xy, n), make(i, ij, xy, y, n), make(ij, j, x, xy, n), make(ij, j, xy, y, n))
        
        n = len(grid)
        return make(0, n, 0, n, n)