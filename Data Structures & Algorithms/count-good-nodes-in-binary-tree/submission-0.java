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
    public int goodNodes(TreeNode root) {
        int [] count = new int[1];
        helper(root, count, root.val, root.val);

        return count[0]; 
    }

    private static void helper(TreeNode root, int[] count, int maxValue, int rootValue){
        if(root == null) return; 
        maxValue = Math.max(maxValue,root.val); 
        helper(root.left, count, maxValue, rootValue); 
        helper(root.right, count, maxValue, rootValue); 
        if(root.val >= rootValue && maxValue <= root.val) count[0] = count[0]+1;
    }
}
