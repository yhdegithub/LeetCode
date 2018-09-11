
public class Solution {
   //树的路径求和
     int res = 0;
    public int sumNumbers(TreeNode root) {
           int sum = 0;
           if(root==null)
               return res;
            dfs(sum,root);
            return res;
    }
  //回溯法
    public void dfs(int sum,TreeNode root){

         if(root==null)
            return;
         sum =  sum*10 + root.val;
        if(root.left==null && root.right==null){
            res += sum ;
            return ;
        }
            //左右递归
            dfs(sum,root.left);
            dfs(sum,root.right);
               }

}