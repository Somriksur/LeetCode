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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        int count=0;
         ListNode temp = head;
        while(temp!=null)
        {
            count++;
            temp = temp.next;
        }
        temp = head;
        int t=1;
        while(t!=count)
        {
            ListNode a = new ListNode(gcd(temp.val,temp.next.val));
           t++;
            a.next = temp.next;
             temp.next = a;
             temp = temp.next.next;
        }
        return head;
    }
    int gcd(int a,int b)
    {
        if(a==0)
        return b;
        return gcd(b%a,a);

    }
}