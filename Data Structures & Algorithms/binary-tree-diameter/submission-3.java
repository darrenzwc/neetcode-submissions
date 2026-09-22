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
    private int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // for every subtree find the max left and max right.
        if(root == null) {
            return 0;
        } 
        getHeight(root);
        return d;
    }
    // get the max depth of this root
    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        d = Math.max(d, getHeight(root.left) + getHeight(root.right));

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
