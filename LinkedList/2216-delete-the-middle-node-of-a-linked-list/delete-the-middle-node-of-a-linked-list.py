# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head.next == None : return None
        pre = head; slow = head; fast = head
        while fast != None and fast.next != None :
            pre = slow
            slow = slow.next
            fast = fast.next.next
        pre.next = slow.next
        return head
        