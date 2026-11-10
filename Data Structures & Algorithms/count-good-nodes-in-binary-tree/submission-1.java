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
    int res = 0; 
    public int goodNodes(TreeNode root) {
        int greatest = root.val; 

        good(root, greatest); 
        
        return res; 
    }

    public void good(TreeNode root, int greatest){
        if(root==null) return; 
        int curr = root.val; 

        if(curr>=greatest){
            greatest = curr; 
            res++; 
        }

        good(root.left,greatest); 
        good(root.right,greatest); 
    }
}
