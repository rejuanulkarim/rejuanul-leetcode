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
        ListNode fast = head, slow = head;
        int res =0;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow.next == null ) return head.val + slow.val;
        ListNode preNode = null;
        ListNode currNode = slow;
        ListNode nextNode = null;
        while(currNode != null){
            nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        ListNode node1 = head, node2 = preNode;
        while(node2 != null){
            res = Math.max(res,node1.val+node2.val);
            node1 = node1.next;
            node2 = node2.next;
        }
        return res;
    }
    
}