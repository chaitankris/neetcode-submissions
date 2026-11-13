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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode p = head;
        ListNode q = head;

        while(p.next !=null && p.next.next!=null){
            p = p.next.next;
            q = q.next;
            if(p==q){
                return true;
            }
        }

        return false;
    }
}
