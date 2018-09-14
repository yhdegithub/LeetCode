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
    public int kthSmallest(TreeNode root, int k) {
        left = k;
        inOrder(root);
        return target==null ? -1 : target.val;
    }
    TreeNode target  = null;
    int left =0;
    public void inOrder(TreeNode root){
        
        if(root==null)
            return;
        inOrder(root.left);
        left--;
        if(left==0){
            target = root;
            return;
        }
        inOrder(root.right);
       
        
    }
    
}