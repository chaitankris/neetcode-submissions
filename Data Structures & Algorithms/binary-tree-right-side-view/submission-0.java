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
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // level order traversal
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode rightMost = null;
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                if(i == size-1){
                    rightMost = cur;
                }
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
            // add right most node for that level
            res.add(rightMost.val);
        }

        return res;
    }
}
