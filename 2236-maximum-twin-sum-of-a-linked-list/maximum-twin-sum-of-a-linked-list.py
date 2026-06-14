# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        res =0
        count =0
        node = head
        arr = []
        while node != None :
            arr.append(node.val)
            count +=1
            node = node.next
        for i in range(count//2):
            res = max(res,arr[i]+arr[count-1-i])
        return res
        