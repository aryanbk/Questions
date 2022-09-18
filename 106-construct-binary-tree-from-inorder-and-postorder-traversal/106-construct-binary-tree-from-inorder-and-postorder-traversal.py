# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, ino: List[int], po: List[int]) -> Optional[TreeNode]:
        def build(post, poend, inst, inend):
            if post>poend or inst>inend: return
            node = TreeNode(po[poend])
            index = mp[po[poend]]
            elements_in_right = inend-index
            elements_in_left = index - inst
            
            node.left = build(post, poend - elements_in_right-1, inst, index-1)
            node.right = build(post + elements_in_left, poend-1, index+1, inend)
            return node
        
        mp, l = {}, len(ino)
        for i in range(l): mp[ino[i]]=i
        return build(0, l-1, 0, l-1)
            
        