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
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }

        ArrayList<Integer> level = new ArrayList<>();
        q.add(root);
        int curr = q.size();

        while(!q.isEmpty()){
            while(curr != 0){
               TreeNode p = q.poll();
               if(p.left != null){
                 q.add(p.left);
               }
               if(p.right != null){
                 q.add(p.right);
               }
               curr--;
               level.add(p.val);
            }
            res.add(level);
            level = new ArrayList<>();
            curr = q.size();
        }

        return res;
    }
}
