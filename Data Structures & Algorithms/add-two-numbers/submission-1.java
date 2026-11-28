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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode cur = ans;
        ListNode prev = cur;
        int carry = 0;
        

        while(l1 !=null && l2 !=null){
            int pos = l1.val + l2.val + carry;
            carry = pos/10;
            cur.val = pos%10;
            cur.next = new ListNode();
            l1 = l1.next;
            l2 = l2.next;
            prev = cur;
            cur = cur.next;
        }

        while(l1 !=null){
            int pos = l1.val + carry;
            carry = pos/10;
            cur.val = pos%10;
            cur.next = new ListNode();
            l1 = l1.next;
            prev = cur;
            cur = cur.next;
        }

        while(l2 !=null){
            int pos = l2.val + carry;
            carry = pos/10;
            cur.val = pos%10;
            cur.next = new ListNode();
            l2 = l2.next;
            prev = cur;
            cur = cur.next;
        }

        if(carry !=0){
            cur.val = carry;
        }else {
          prev.next = null;
        }
        
        return ans;
    }
}
