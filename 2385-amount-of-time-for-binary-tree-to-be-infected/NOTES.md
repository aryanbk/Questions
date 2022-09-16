```
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
up={}
q=[root]
st=None
while len(q)>0:
l=len(q)
for _ in range(l):
node=q.pop(0)
if node.val==start:
st=node
if node.left:
q.append(node.left)
up[node.left.val]=node
if node.right:
q.append(node.right)
up[node.right.val]=node
q.append(st)
ans=0
print(q)
while len(q)>0:
l=len(q)
print(l)
for _ in range(l):
node=q.pop(0)
if node.left: q.append(node.left)
if node.right: q.append(node.right)
if node.val in up: q.append(up[node.val])
ans+=1
return ans
```