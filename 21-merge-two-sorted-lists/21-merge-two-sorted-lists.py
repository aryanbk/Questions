# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list2:
            return list1
        if not list1:
            return list2
        if list1.val>list2.val:
            return self.mergeTwoLists(list2, list1)
        h1,h2=list1, list2
        while h1 and h2 and h1.next:
            if h2.val<h1.val:
                t = h2
                h2 = h1
                h1=t
            if h1.next.val<h2.val:
                h1=h1.next
            else:
                temp2=h2.next
                h2.next=h1.next
                h1.next=h2
                h1=h2
                h2=temp2
        if not h1.next:
            h1.next=h2
        return list1
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        