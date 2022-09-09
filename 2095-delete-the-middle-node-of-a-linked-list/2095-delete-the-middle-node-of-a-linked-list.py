# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy=ListNode(-1)
        dummy.next=head
        fast=head
        slow=dummy
        while fast and fast.next:
            fast=fast.next.next
            slow=slow.next
        slow.next=slow.next.next
        return dummy.next
            
        