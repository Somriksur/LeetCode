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
    public ListNode doubleIt(ListNode head) {
        if (head == null)
            return null;

        ListNode reversed = reverseNodes(head);
        mulitplyByTwo(reversed);
        return reverseNodes(reversed);
    }

    private ListNode reverseNodes(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private void mulitplyByTwo(ListNode head) {
        int carry = 0;
        ListNode curr = head;

        while (curr != null) {
            int doubleVal = curr.val * 2 + carry;
            carry = doubleVal / 10;
            curr.val = doubleVal % 10;
            if (curr.next == null && carry > 0) {
                curr.next = new ListNode(carry);
                break;
            }
            curr = curr.next;
        }
    }
}