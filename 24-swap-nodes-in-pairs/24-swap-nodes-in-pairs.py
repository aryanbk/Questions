# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        hn=head.next
        hnn=head.next.next
        
        hn.next=head
        head.next = self.swapPairs(hnn)
        return hn
        