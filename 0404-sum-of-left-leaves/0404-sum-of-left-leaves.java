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

    public int left = 0;

    public int sumOfLeftLeaves(TreeNode root) {

        class Traverse {
            Traverse(TreeNode root) {
                TreeNode temp = root;
                if (temp.left != null) {
                    if (temp.left.left == null && temp.left.right == null)
                        left += temp.left.val;
                    new Traverse(temp.left);
                }
                if (temp.right != null) {
                    new Traverse(temp.right);
                }
            }
        }

        new Traverse(root);
        return left;

    }
}