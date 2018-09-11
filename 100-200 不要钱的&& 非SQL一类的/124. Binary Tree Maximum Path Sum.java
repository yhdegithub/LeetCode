/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * } Binary Tree Maximum Path Sum
 */
import java.util.*;
class Solution {
    int max  = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        int l = Math.max(0,dfs(root.left)) , r = Math.max(dfs(root.right) , 0);
      max = Math.max(max , l+r+ root.val);
        return root.val + Math.max(l,r);
    
    }
}