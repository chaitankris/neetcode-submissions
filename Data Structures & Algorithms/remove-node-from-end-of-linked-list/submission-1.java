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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null ){
            return null;
        }
        ListNode cur = head;
        ListNode nth = head;
        ListNode skip = nth;
        int pos = 1;

        while(cur.next != null){
            cur = cur.next;
            pos++;
            if(pos-n > 0){
                skip = nth;
                nth = nth.next;
            }
        }

        if(n == pos){
            return head.next;
        }

        skip.next = nth.next;

        return head;
    }
}
