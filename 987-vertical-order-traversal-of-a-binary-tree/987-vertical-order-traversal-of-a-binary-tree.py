# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        ht={}
        mnc, mxc = 1001,-1001
        
        def bs(arr, k, v):
            lo, hi, res = 0, len(arr)-1, 0
            while lo<=hi:
                mid=(lo+hi)//2
                if arr[mid][1]==k:
                    if arr[mid][0].val<v:
                        res=mid
                        lo=mid+1
                    else:
                        hi=mid-1
                elif arr[mid][1]<k:
                    res=mid
                    lo=mid+1
                elif arr[mid][1]>k:
                    hi=mid-1
            return res
        
        def dfs(root, row, col):
            if not root:
                return
            nonlocal mnc,mxc
            mnc=min(col, mnc)
            mxc=max(col, mxc)
            if col not in ht:
                ht[col]=[[root, -1],[root, row]]
            else:
                index=bs(ht[col], row, root.val)
                ht[col].insert(index+1, [root, row])
            dfs(root.left, row+1, col-1)
            dfs(root.right, row+1, col+1)
        
        dfs(root, 0, 0)
        ans=[]
        for i in range(mnc, mxc+1):
            sub=[]
            for j in range(1, len(ht[i])):
                sub.append(ht[i][j][0].val)
            ans.append(sub)
        return ans