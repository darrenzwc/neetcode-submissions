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

// Traverse both left and right. I want to in turn get the biggest depth of the subtree
class Solution {
    public int maxDepth(TreeNode root) {
        if(root != null) {
            return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
        }
        return 0;
    }
}
