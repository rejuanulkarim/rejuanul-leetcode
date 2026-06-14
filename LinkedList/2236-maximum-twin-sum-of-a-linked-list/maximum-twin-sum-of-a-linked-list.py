# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        # Find Middle of Linked List
        slow = head; fast = head
        while(fast != None and fast.next != None):
            slow = slow.next
            fast = fast.next.next
        # Reverse 2nd half Linkedlist
        preNode = None
        while(slow != None):
            next = slow.next
            slow.next = preNode
            preNode = slow
            slow = next
        #Find max sum
        res=0
        node1 = head; node2 = preNode
        while node2 != None:
            res = max(res,node1.val + node2.val)
            node1 = node1.next
            node2 = node2.next
        return res 