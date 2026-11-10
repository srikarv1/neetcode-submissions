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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true; 

        return valid(root, new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}); 

    }

    public boolean valid(TreeNode root, int[] range){
        if(root==null) return true; 
        if(root.val <= range[0] || root.val>= range[1]){
            return false; 
        }

        boolean left = valid(root.left, new int[]{range[0],Math.min(range[1],root.val)}); 

        boolean right = valid(root.right, new int[]{Math.max(range[0],root.val),range[1]});

        return left && right;  
    
    }
}
