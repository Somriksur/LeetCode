/*
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
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        if(head.next==null) return true;
        ListNode fast=head,slow=head;

        //Determine the middle element 
        if(fast.next.next==null&&fast.val!=fast.next.val) return false;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        //reverse the linked linked from half
        ListNode list2=reverse(slow);
        slow.next=null;
        fast=head;
        slow=list2;

        //check whether the reversed half and original half are the same
        while(fast!=null&&slow!=null){
            if(fast.val!=slow.val) return false;
            fast=fast.next;
            slow=slow.next;
        }
        return true;
    
    }

    //Reverse the list of the second half

    public static ListNode reverse(ListNode head){
        ListNode curr=head,next=null,prev=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

}