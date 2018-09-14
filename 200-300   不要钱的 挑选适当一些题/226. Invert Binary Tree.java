/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null ||(root.left==null && root.right==null))
             return root;
        invertTree(root.left);
        invertTree(root.right);
        
         TreeNode t =null ;
        if(root!=null)
            t = root.left;
        root.left = root.right;
         root.right = t;
    return root;    
    }
}