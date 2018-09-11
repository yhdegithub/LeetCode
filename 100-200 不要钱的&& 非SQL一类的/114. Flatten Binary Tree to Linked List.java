/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
*  一看规律就是先序，所以dfs按照先序的写
*
*
*
***/
class Solution {
    public void flatten(TreeNode root) {
        if(root==null|| (root.left==null&&root.right==null))
            return;
        dfs(root);
        TreeNode cur = root;
        while(cur!=null){   //最后注意做指针要置空
            cur.left =null;
            cur = cur.right;
        }
    }
    public TreeNode dfs(TreeNode root){
        if(root==null ||(root.left==null&&root.right==null))
            return root;
        TreeNode t = root.right;  //要修改right指针,所以右孩子先保存起来
        root.right = dfs(root.left);
        TreeNode tail =root;
        while(tail!=null && tail.right!=null)
            tail = tail.right;
        if(tail!=null)
            tail.right = dfs(t);
        return root;
    }
    public static void main(String args[]){
       
    }
}