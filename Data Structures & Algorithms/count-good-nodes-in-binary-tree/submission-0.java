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
    int good;
    public int goodNodes(TreeNode root) {
        good = 0;
        preorder(root, root.val);
        return good;
    }

    public void preorder(TreeNode root, int greatest){
        if(root == null){
            return;
        }
        
        if(root.val >= greatest){
            good++;
        }
        preorder(root.left, Math.max(greatest, root.val));
        preorder(root.right, Math.max(greatest, root.val));
    }
}
