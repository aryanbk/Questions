# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry=0
        node=ListNode(-1)
        ans=node
        while l1 and l2:
            sm=carry+l1.val+l2.val
            node.next=ListNode(sm%10)
            node=node.next
            carry=sm//10
            l1=l1.next
            l2=l2.next
        while l1:
            sm=carry+l1.val
            node.next=ListNode(sm%10)
            carry=sm//10
            node=node.next
            l1=l1.next
        while l2:
            sm=carry+l2.val
            node.next=ListNode(sm%10)
            carry=sm//10
            node=node.next
            l2=l2.next
        if carry!=0:
            node.next=ListNode(carry)
        return ans.next
            
        