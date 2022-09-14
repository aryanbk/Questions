# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pseudoPalindromicPaths (self, root: Optional[TreeNode]) -> int:
        ans = 0
        def dfs(root, st):
            if (not root.left) and (not root.right):
                nonlocal ans
                if root.val in st: st[root.val] += 1
                else: st[root.val]=1
                t=0
                for i in st:
                    if st[i]%2!=0: t+=1
                if t<2: ans+=1
                return
            if root.val in st: st[root.val] += 1
            else: st[root.val] = 1
            st2=st.copy()
            if root.left: dfs(root.left, st)
            if root.right: dfs(root.right, st2)
            return
        dfs(root, {})
        return ans