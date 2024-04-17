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
    String smallest = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallest;
    }
     private void dfs(TreeNode node, StringBuilder path) {
        if (node == null) return;
        path.insert(0, (char)('a' + node.val));
        if (node.left == null && node.right == null) {
            String currentPath = path.toString();
            if (currentPath.compareTo(smallest) < 0) {
                smallest = currentPath;
            }
        }
        dfs(node.left, path);
        dfs(node.right, path);
        path.deleteCharAt(0);
    }
}