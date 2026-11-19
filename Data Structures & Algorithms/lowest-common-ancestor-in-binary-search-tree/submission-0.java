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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while(cur != null){
            // if both nodes are lower that cur value go left
            if(cur.val > p.val && cur.val > q.val){
                cur = cur.left;
            } // if both nodes are greater that cur value go right
            else if( cur.val < p.val && cur.val < q.val){
                cur = cur.right;
            } // split happens means its lowest common ancestor
            else{
                return cur;
            }
        }

        return cur;
    }
}
