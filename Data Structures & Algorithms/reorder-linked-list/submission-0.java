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
    public void reorderList(ListNode head) {
        List<Integer> values = new ArrayList<>();

        ListNode cur = head;
        while(cur != null){
            values.add(cur.val);
            cur = cur.next;
        }
        int size = values.size(), i=0;
        cur = head;

        while(i<size/2){
            cur.val = values.get(i);
            cur = cur.next;
            cur.val = values.get(size - 1 -i);
            cur = cur.next;
            i++;
        }

        if(size%2 == 1){
            cur.val = values.get(i);
        }

    }
}
