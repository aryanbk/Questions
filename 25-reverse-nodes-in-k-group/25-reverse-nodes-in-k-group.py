# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = 

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        d=ListNode(-1,head)
        dummy=d
        ptr=head
        l=0
        while ptr:
            ptr=ptr.next
            l+=1
        i=l//k
        ptr=head
        while ptr and i>0 and dummy:
            prev=dummy
            curr=ptr
            nx=curr.next
            k1=k
            while curr and k1>0:
                curr.next=prev
                prev=curr
                curr=nx
                if nx:
                    nx=nx.next
                k1-=1
            dummy.next=prev
            ptr.next=curr
            k1=k
            dummy=ptr
            ptr=ptr.next
            i-=1
        return d.next
            
                

            
            