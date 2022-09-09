# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        
        def rev(h):
            prev=None
            curr=h
            nx=h.next
            while curr:
                curr.next=prev
                prev=curr
                curr=nx
                if nx:
                    nx=nx.next
            return prev
        slow=head
        fast=head
        while fast.next:
            fast=fast.next.next
            if fast==None or fast.next==None:
                l2=rev(slow.next)
                while head and l2:
                    if head.val!=l2.val:
                        return False
                    head=head.next
                    l2=l2.next
                return True
            slow=slow.next
        return True