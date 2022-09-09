"""
# Definition for a Node.
class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""

class Solution:
    def flatten(self, head: 'Optional[Node]') -> 'Optional[Node]':
        ptr=head
        while ptr and ptr.child==None:
            ptr=ptr.next
        if not ptr:
            return head
        else:
            ptr2=ptr.next
            res=self.flatten(ptr.child)
            ptr.next=res
            ptr.child=None
            res.prev=ptr
            last=ptr
            while last.next:
                last=last.next
            last.next=ptr2
            if ptr2:
                ptr2.prev=last
            return self.flatten(head)