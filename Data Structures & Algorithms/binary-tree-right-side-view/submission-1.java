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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        queue.add(root);
        while(!queue.isEmpty()) {
            int level_size = queue.size();
            int rightVal = 0;
            for(int i = 0; i < level_size; i++) {
                TreeNode node = queue.poll();
                rightVal = node.val;
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(rightVal);
        }

        return result;
    }
}
