# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, pre: List[int], ino: List[int]) -> Optional[TreeNode]:
        def build(prest, preend, inst, inend):
            if prest>preend or inst>inend: return None
            node = TreeNode(pre[prest])
            ind=mp[pre[prest]]
            indleft = ind - inst
            node.left = build(prest+1, prest+indleft, inst, ind-1)
            node.right = build(prest+indleft+1, preend, ind+1, inend)
            return node
        
        mp, l = {}, len(ino)
        for i in range(l):
            mp[ino[i]]=i
        return build(0, l-1, 0, l-1)