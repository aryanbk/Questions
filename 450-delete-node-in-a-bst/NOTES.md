didn't work
```
class Solution:
def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
ptr=root
while ptr:
if ptr.val==key:
if ptr.right:
ptr.val=ptr.right.val
ptr.right=ptr.right.right
elif ptr.left:
ptr.val=ptr.left.val
ptr.left=ptr.left.left
else:
if ptr==root: return None
else: ptr=None
return root
elif ptr.val>key: ptr=ptr.left
elif ptr.val<key: ptr=ptr.right
​
# if key does not exist
return root
```