/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        // Middle of the Linked List
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse 2nd half linked list
        ListNode preNode = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = preNode;
            preNode  = slow;
            slow = next;
        }
        // find maximum sum
        int res = Integer.MIN_VALUE;
        ListNode node1 = head, node2 = preNode;
        while(node2 != null){
            res = Math.max(res,node1.val+node2.val);
            node1 = node1.next;
            node2 = node2.next;
        }
        return res;
    }
}