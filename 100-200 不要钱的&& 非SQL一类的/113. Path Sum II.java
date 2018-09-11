
import java.util.*;
class Solution {
    List<List<Integer>> res =new ArrayList<>();
    List<Integer>one  = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        int all=0;
      res =  dfs(root,sum,all);
      return  res;
    }
     //
    private List<List<Integer>> dfs(TreeNode root,int sum,int all)
    {
        if(root==null)  return res;
        one.add(root.val);
        all+=root.val;
        if(root.left==null&&root.right==null && all==sum )//叶子结点
        {
            res.add(new ArrayList<>(one));
             all=all-one.get(one.size()-1);
            one.remove(one.size()-1);
            return res;
        }
        if(root.left!=null)  dfs(root.left,sum,all);
        if(root.right!=null) dfs(root.right,sum,all);
        all=all-one.get(one.size()-1);
        one.remove(one.size()-1);
       return res;
        
    }
}