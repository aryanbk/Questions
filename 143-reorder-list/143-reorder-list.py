# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        def rev(head):
            if not head:
                return head
            prev=None
            curr=head
            nx=head.next
            while curr!=None:
                curr.next=prev
                prev=curr
                curr=nx
                if nx:
                    nx=nx.next
            return prev
        fast=head
        slow=head
        while fast and fast.next:
            fast=fast.next.next
            slow=slow.next
        head2 = rev(slow)
        head1=head
        nx2=head2.next
        nx1=head1.next
        while nx1 and nx2:
            head1.next=head2
            head2.next=nx1
            head1=nx1
            head2=nx2
            nx1=nx1.next
            nx2=nx2.next

        
        