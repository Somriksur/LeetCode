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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for(int[] i : ans)
            Arrays.fill(i,-1);

        int left = 0 , right = n-1;
        int top = 0 , bottom = m-1;

        ListNode th = head;

        while(left <= right  && top <= bottom && th!=null)
        {
            for(int i = left ; i<=right && th!=null ;i++)
            {
                ans[top][i] = th.val;
                th = th.next;
            }
            top++;

            for(int i = top ; i<= bottom && th!=null ;i++)
            {
                ans[i][right] = th.val;
                th = th.next;
            }
            right--;

            for(int i = right ; i>=left && th!=null ;i--)
            {
                ans[bottom][i] = th.val;
                th = th.next;
            }
            bottom --;

            for(int i = bottom ; i>=top  && th!=null ;i--)
            {
                ans[i][left] = th.val;
                th = th.next;
            }
            left++;

        }
        return ans;
    }
}