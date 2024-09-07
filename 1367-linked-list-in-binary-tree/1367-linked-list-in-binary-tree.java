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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  private boolean test(ListNode lNode, TreeNode tNode) {
    if (lNode == null) return true;
    if (tNode == null) return false;

    return lNode.val == tNode.val && (test(lNode.next, tNode.left) || test(lNode.next, tNode.right));
  }

  public boolean isSubPath(ListNode head, TreeNode node) {
    if (node == null)
      return false;
    
    if (test(head, node))
      return true;

    return isSubPath(head, node.left) || isSubPath(head, node.right);
  }
}