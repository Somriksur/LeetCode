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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count=0;
        ListNode ptr=list1,ptr2=list2;
        while(count<a-1)
        {
            ptr=ptr.next;
            count++;
        }
        ListNode temp=ptr.next;
        while(ptr2!=null)
        {
            ptr.next=ptr2;
            ptr=ptr.next;
            ptr2=ptr2.next;
        }
        while(count<b && temp!=null)
        {
            temp=temp.next;
            count++;
        }
        while(temp!=null)
        {
            ptr.next=temp;
            ptr=ptr.next;
            temp=temp.next;
        }
        return list1;
    }
}