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
    public TreeNode buildTree(int[] pre, int[] in) {
        int n =pre.length;
        if(n==0)  return null;
        return dfs(pre,0,n-1,in,0,n-1);
    }
    public TreeNode dfs(int pre[],int preLow,int preHigh,int in[],int inLow,int inHigh){
      if(preLow>preHigh || inLow>inHigh)
          return null;
        int pos = getLoc(pre[preLow],in);
        TreeNode root = new TreeNode(pre[preLow]);
        root.left =dfs(pre,preLow+1,preLow + pos - inLow,in,inLow,pos-1);
        root.right =dfs(pre,preLow + pos - inLow+1,preHigh,in,pos+1,inHigh) ;
        return root;
        
    }
    public int getLoc(int target,int a[]){
        for(int i=0;i<a.length;i++)
            if(a[i]==target)
                return i;
        return -1;
        
    }
    
}