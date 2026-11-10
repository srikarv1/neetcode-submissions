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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // pre [1,2,3,4]
        // in [2,1,3,4]
        
        return build(0,preorder,inorder,0,inorder.length-1); 
    }

    public TreeNode build(int i, int[] preorder, int[] inorder, int l, int r){
        if(i>=preorder.length) return null; 
        if(l>r) return null; 
        TreeNode curr = new TreeNode(preorder[i]); 
        int idx = find(inorder,preorder[i]); 
        int leftSize = idx - l;
        curr.left = build(i+1,preorder,inorder,l, idx-1);
        curr.right = build(i+1+leftSize,preorder,inorder,idx+1, r);
        return curr; 
    }

    public int find(int[] inorder, int x){
        for(int i=0;i<inorder.length; ++i){
            if(inorder[i] == x) return i; 
        }
        return -1; 
    }
}
