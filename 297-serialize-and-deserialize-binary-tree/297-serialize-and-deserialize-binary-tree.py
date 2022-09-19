# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):

        def dfs(root):
            nonlocal res
            if not root:
                res+="#,"
                return
            res += str(root.val)+","
            dfs(root.left)
            dfs(root.right)
        
        #
        res=""
        dfs(root)
        return res
        

    def deserialize(self, data):

        def dfs():
            nonlocal ptr
            if ptr>=len(ip) or ip[ptr]=="#":
                ptr+=1
                return None
            node = TreeNode(int(ip[ptr]))
            ptr+=1
            node.left=dfs()
            node.right=dfs()
            return node
        
        
        #data = 1,2,#,#,3,4,#,#,5,#,#,
        ip, ptr = list(data.split(",")), 0
        return dfs()
        
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))