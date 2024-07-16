/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private static char[] pathArray = new char[100001];
    private static int frontPtr, backPtr;
    private static int srcVal, destVal;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        Solution.srcVal = startValue;
        Solution.destVal = destValue;
        frontPtr = 0;
        backPtr = 100000;
        navigateTree(root);
        return frontPtr > 0 ? new String(pathArray, 0, frontPtr) : new String(pathArray, backPtr + 1, 100000 - backPtr);
    }

    private static int navigateTree(TreeNode node) {
        if (node == null)
            return 0;

        if (node.val == destVal) {
            return (locateSource(node.left) || locateSource(node.right)) ? -1 : destVal;
        }

        if (node.val == srcVal) {
            return (locateDest(node.left, 'L') || locateDest(node.right, 'R')) ? -1 : srcVal;
        }

        int leftOutcome = navigateTree(node.left);
        if (leftOutcome != 0) {
            if (leftOutcome == -1)
                return -1;
            if (leftOutcome == destVal) {
                pathArray[backPtr--] = 'L';
                return locateSource(node.right) ? -1 : leftOutcome;
            } else {
                pathArray[frontPtr++] = 'U';
                return locateDest(node.right, 'R') ? -1 : leftOutcome;
            }
        }

        int rightOutcome = navigateTree(node.right);
        if (rightOutcome != 0) {
            if (rightOutcome == -1)
                return -1;
            pathArray[rightOutcome == destVal ? backPtr-- : frontPtr++] = rightOutcome == destVal ? 'R' : 'U';
            return rightOutcome;
        }

        return 0;
    }

    private static boolean locateSource(TreeNode node) {
        if (node == null)
            return false;
        pathArray[backPtr--] = 'U';
        if (node.val == srcVal)
            return true;
        if (locateSource(node.left) || locateSource(node.right))
            return true;
        backPtr++;
        return false;
    }

    private static boolean locateDest(TreeNode node, char direction) {
        if (node == null)
            return false;
        pathArray[frontPtr++] = direction;
        if (node.val == destVal)
            return true;
        if (locateDest(node.left, 'L') || locateDest(node.right, 'R'))
            return true;
        frontPtr--;
        return false;
    }
}