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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        ListNode newCur = dummyNode;
        ListNode cur = head;

        while (true) {
            int sum = 0;
            while (cur.next != null && cur.next.val != 0) {
                cur = cur.next;
                sum += cur.val;
            }
            newCur.next = new ListNode(sum);
            newCur = newCur.next;
            cur = cur.next;
            if (cur.next == null) break;
        }

        return dummyNode.next;
    }
}