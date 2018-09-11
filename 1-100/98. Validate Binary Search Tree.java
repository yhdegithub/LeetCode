
import java.util.*;
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))
            return true;
        TreeNode cur = root ,pre=null;
        Stack<TreeNode> stack = new Stack<>();
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(pre!=null && pre.val >= cur.val)
                return false;
            pre = cur;
            cur = cur.right;
        }

        return true;
    }
  
    public static void main(String args[]){
        int pre[] = {5,1,4,3,6};
        int in[] = {1,5,3,4,6};
        Solution s = new Solution();
        TreeNode root = s.buildTree(pre,in);
        System.out.println(s.isValidBST(root));
    }
}