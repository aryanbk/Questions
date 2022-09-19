# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        def dfs(root):
            if not root: return
            dfs(root.left)
            self.ino.append(root.val)
            dfs(root.right)
        
        self.ino=[]
        self.ptr=0
        dfs(root)
        

    def next(self) -> int:
        ans = self.ino[self.ptr]
        self.ptr+=1
        return ans

    def hasNext(self) -> bool:
        return self.ptr<len(self.ino)


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()