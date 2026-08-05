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
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root); 

        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>(); 

            for(int i=q.size(); i>0; --i){
                TreeNode t = q.poll();
                if(t != null){  
                    level.add(t.val); 
                    q.add(t.left);
                    q.add(t.right);   
                }
            }
            if(level.size()>0)
            res.add(level.get(level.size()-1));
        }

        return res; 
    }
}
