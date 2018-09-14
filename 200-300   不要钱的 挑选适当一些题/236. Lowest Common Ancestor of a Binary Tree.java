/**

import java.util.*;
//可以考虑递归，简直不要好写太多
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==root || q==root)
            return root;
        TreeNode l  = lowestCommonAncestor(root.left , p ,q);
         TreeNode r  = lowestCommonAncestor(root.right , p ,q);
        if(l!=null&&r!=null)
            return root;
        return l==null ? r:l;
    }
}
    
    
    **/

import  java.util.*;
//最低祖先 ， 先找到路径 ， 然后求这个路径的第一个交叉点
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
           if(root==null || p==root || q==root)
               return root;
           ArrayList<TreeNode> list1 = new ArrayList<>();list1.add(root);
        ArrayList<TreeNode> list2 = new ArrayList<>();list2.add(root);
        list1 = path(root,list1,p);
        res = false;
        list2 = path(root,list2,q);
        TreeNode key = find(list1,list2);
        return key;
    }
    //找祖先
    public TreeNode find(ArrayList<TreeNode>list1 , ArrayList<TreeNode> list2){
        int m =list1.size() , n = list2.size();
        if(m<n)   return find(list2,list1);
        int dif = m-n;
       int i = m -1 - dif;
       int j = n-1;
       while(list1.get(i) != list2.get(j)){
           i--;
           j--;
       }
       return list1.get(i);
    }
    //找路径
    boolean res = false;
    public ArrayList<TreeNode> path(TreeNode root , ArrayList<TreeNode>list ,TreeNode target){
        if(root.val==target.val){
            res = true;
            return list;
        }
        if(root==null || (root.left==null && root.right==null))
            return list;
        if(root.left!=null && !res){
            list.add(root.left);
            path(root.left,list,target);
            if(res)
                return list;
            list.remove(list.size()-1);
        }
        if(root.right!=null && !res){
            list.add(root.right);
            path(root.right,list,target);
            if(res)
                return list;
            list.remove(list.size()-1);
        }
        return list;
    }
  
}