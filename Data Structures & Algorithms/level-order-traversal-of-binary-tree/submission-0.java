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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        q.add(root);

        while(!q.isEmpty()) {
            List<Integer> sublist = new ArrayList<>();
            int level_num = q.size();
            for(int i = 0; i < level_num; i++) {
                TreeNode node = q.poll();
                sublist.add(node.val);
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            result.add(sublist);
        }

        return result;
    }
}
