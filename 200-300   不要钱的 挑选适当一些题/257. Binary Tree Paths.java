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
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)
            return res;
        dfs(String.valueOf(root.val), root);
        return res;
    }
    public void dfs(String one , TreeNode root){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            res.add(new String(one));
            return;
        }
        if(root.left!=null){
            one += "->" + String.valueOf(root.left.val);
            dfs(one,root.left);
            one = one.substring(0,one.length()-2-String.valueOf(root.left.val).length());
        }

        if(root.right!=null){
            one += "->" + String.valueOf(root.right.val);
            dfs(one,root.right);
            one = one.substring(0,one.length()-2-String.valueOf(root.right.val).length());
        }

    }
    public static void main(String args[]){
       // TreeNode root  =new BuildTree().buildTree(new int[]{4,2,1,3,6,5,7} , new int[]{1,2,3,4,5,6,7});
      //  System.out.println(new Solution().binaryTreePaths(root));
    }
}