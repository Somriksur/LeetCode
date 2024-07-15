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
    public TreeNode createBinaryTree(int[][] descriptions) {
     Map<Integer,TreeNode>   nodes=new HashMap<>();
     Set<Integer> children= new HashSet<>();
     
        for(int []d:descriptions){
            nodes.putIfAbsent(d[0],new TreeNode(d[0]));
            
            nodes.putIfAbsent(d[1],new TreeNode(d[1]));
            if(d[2]==1){
                nodes.get(d[0]).left=nodes.get(d[1]);
            } else {
                nodes.get(d[0]).right=nodes.get(d[1]);
            }
            children.add(d[1]);
        }
        for(int key:nodes.keySet()){
            if(!children.contains(key)) return nodes.get(key);
        }
        return null;
    }
}