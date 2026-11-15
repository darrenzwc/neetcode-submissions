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
    public boolean isBalanced(TreeNode root) {
        // basically invalid the moment left child valid 
        // Continue investigating every sub-tree
        if(root == null) {
            return true;
        }
        boolean balanced = Math.abs(getHeight(root.left) -                                    getHeight(root.right)) < 2;
        return balanced && isBalanced(root.left) && isBalanced(root.right);
        
    }
    private int getHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return Math.max(1 + getHeight(node.left), 1 + getHeight(node.right));
    }
}
