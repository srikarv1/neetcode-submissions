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
        int[] res = new int[1];
        res[0]=1;
        int x = helper(root,res); 
        if(res[0]==1) return true;
        return false; 
    }

    private static int helper(TreeNode root, int[] res){
        if(root == null) return 0;

        int left = helper(root.left, res);
        int right = helper(root.right, res);
        if(Math.abs(right-left) > 1) res[0]=0; 
        return (1+Math.max(left,right)); 
    }
}
