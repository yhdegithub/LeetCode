/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return IsBalanced_Solution(root);
    } 
    public boolean IsBalanced_Solution(TreeNode root) {
       if(root==null || (root.left==null&&root.right==null))
            return true;
        dfs(root);
        return flag;
    }
   boolean flag = true;
    //后序遍历
    public int dfs(TreeNode root){
         if(root==null)
            return 0;
        if (root.left==null&&root.right==null)
            return 1;
            int l = dfs(root.left);
            int r =dfs(root.right);
           if(Math.abs(l-r)>1){
              flag = false;
               return 100;
           }
        return Math.max(l,r)+1;
    }
}