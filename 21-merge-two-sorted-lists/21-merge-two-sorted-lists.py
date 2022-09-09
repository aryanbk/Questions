# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# class Solution:
#     def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
#         if list1.val<list2.val:
#             return mergeTwoLists(self, list2, list1)
#         h1=list1
#         h2=list2.next
#         prev2=list2
#         while h1 and h2:
#             # if h2.val<h1.val:
#             #     prev2=h2
#             #     h2=h2.next
#             if h2.val>h1.val and prev2.val<=h1.val:
#                 print(h1.val, h2.val, prev2.val)
#                 nx1=h1.next
#                 prev2.next=h1
#                 h1.next=h2
#                 prev2=h1
#                 h1=nx1
#                 print(h1.val, h2.val, prev2.val)
#             else:
#                 print(h1.val, h2.val, prev2.val)
#                 prev2=h2
#                 h2=h2.next
#             prev2.next=h1
#         return list2
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
                # temp1=h1.next
                h2.next=h1.next
                h1.next=h2
                h1=h2
                h2=temp2
                # h1.next=h2
                # h2.next=temp1
                # h1=h2
                # h2=temp2

        if not h1.next:
            h1.next=h2
        return list1
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        