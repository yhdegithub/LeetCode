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
    public TreeNode sortedArrayToBST(int[] nums) {
         if(nums==null || nums.length==0)
             return null;
        int n =nums.length;
       return dfs(nums,0,n-1);
    }
    public TreeNode dfs(int nums[],int low,int high){
        if(low>high)
            return null;
        if(low==high)
            return new TreeNode(nums[low]);
        int mid = (low +high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,low,mid-1);
        root.right = dfs(nums,mid+1,high);
        return root;
    }
}