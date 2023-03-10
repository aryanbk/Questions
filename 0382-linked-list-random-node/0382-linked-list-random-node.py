# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    def __init__(self, head: Optional[ListNode]):
        self.a=[]
        ptr=head
        while ptr:
            self.a.append(ptr.val)
            ptr = ptr.next

    def getRandom(self) -> int:
        return random.choice(self.a)


# Your Solution object will be instantiated and called as such:
# obj = Solution(head)
# param_1 = obj.getRandom()