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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> arr=findLocalMinMax(head);
        if(arr.size()<2)
            return new int[]{-1,-1};
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.size()-1;i++){
            min=Math.min(arr.get(i+1)-arr.get(i),min);
        }
        int max=arr.get(arr.size()-1)-arr.get(0);
        return new int[]{min,max};
    }
    public static  ArrayList<Integer> findLocalMinMax(ListNode head) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        if (head == null || head.next == null) {
            return arr;
        }

        ListNode current = head;
        int position = 1;

        while (current != null && current.next != null && current.next.next != null) {
            int prevVal = current.val;
            int nextVal = current.next.val;
            int nextNextVal = current.next.next.val;

            if ((prevVal > nextVal && nextVal < nextNextVal) || (prevVal < nextVal && nextVal > nextNextVal)) {
                arr.add(position);
            }

            current = current.next;
            position++;
        }
        return arr;
    }

}