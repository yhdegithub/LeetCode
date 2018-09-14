/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //用遍历所有节点的方法会超时 ，没利用好完全二叉树的性质 。 我们设想补成满二叉树
import java.util.*;
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        if(root.right==null && root.left==null)
            return 1;
        int l_len = 0 ,r_len =0;
        TreeNode l = root , r = root;
        while(l!=null){
            l_len++;
            l = l.left;
        }
        while(r!=null){
            r_len++;
            r = r.right;
        }
        if(l_len==r_len)
            return  (int)Math.pow(2,l_len ) - 1;
        else
            return 1 +  countNodes(root.left) + countNodes(root.right);
    }
}