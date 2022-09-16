# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        mp, q = {root.val:None}, [root]
        while q:
            l=len(q)
            for _ in range(l):
                node=q.pop(0)
                if node.left:
                    mp[node.left.val]=node
                    q.append(node.left)
                if node.right:
                    mp[node.right.val]=node
                    q.append(node.right)
        st=set()
        def dfs(root, k):
            nonlocal q
            if not root or k<0 or root.val in st: return
            if k==0: 
                q.append(root.val)
                return
            st.add(root.val)
            dfs(root.left, k-1)
            dfs(root.right, k-1)
            dfs(mp[root.val], k-1)
        
        dfs(target, k)
        return q
                    
        