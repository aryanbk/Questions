# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        s,f=head,head
        while f and f.next:
            f=f.next.next
            s=s.next
            if s==f:
                a=head
                while a!=s:
                    a=a.next
                    s=s.next
                return a
        return None
        