//也可以层次遍历 ，直到一个叶子结点
import java.util.*;
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
       return 0;
        return run(root);
    }
     public int run(TreeNode root) {
      if(root==null)
          return 0;
        if(root.left==null && root.right==null)
            return 1;
        if(root.left==null)
            return run(root.right)+1;
        if(root.right==null)
         return run(root.left)+1;
        return  Math.min(run(root.left),run(root.right))+1;
    }
}