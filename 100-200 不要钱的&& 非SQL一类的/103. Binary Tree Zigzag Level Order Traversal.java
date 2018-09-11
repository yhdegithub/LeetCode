
import java.util.*;
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
          if(root==null)
              return res;
          Stack<TreeNode> stack1 = new Stack<>();
         Stack<TreeNode> stack2 = new Stack<>();
         stack1.push(root);
         int level = 1;
         while( !stack1.isEmpty() || !stack2.isEmpty()){
             level++;
             List<Integer> one = new ArrayList<>();
             if((level&1)==0){   //1,3,5,7.。。。层是从左到右的
                 while(!stack1.isEmpty()){
                     TreeNode cur = stack1.pop();
                     one.add(cur.val);
                     if(cur.left!=null)
                         stack2.push(cur.left);
                     if(cur.right!=null)
                         stack2.push(cur.right);
                 }
             } else{               //偶数层
                 while(!stack2.isEmpty()){
                     TreeNode cur = stack2.pop();
                     one.add(cur.val);
                     if(cur.right!=null)
                         stack1.push(cur.right);
                     if(cur.left!=null)
                         stack1.push(cur.left);
                 }
             }
             res.add(new ArrayList<>(one));
         }
    return res;
    }
    //jianshu
    public TreeNode buildTree(int[] pre, int[] in) {
        if(pre==null||pre.length==0)
            return null;
        int n = pre.length;
        return dfs(pre,0,n-1,in,0,n-1);
    }
    //
    public TreeNode dfs(int pre[],int preLow,int preHigh,int in[],int inLow,int inHigh){
        if(preLow>preHigh || inLow>inHigh)
            return null;
        TreeNode root = new TreeNode(pre[preLow]);
        int index = find(in,pre[preLow]);
        root.left = dfs(pre,preLow+1,index-inLow+preLow ,in,inLow,index-1);
        root.right = dfs(pre,index-inLow+preLow+1,preHigh ,in,index+1,inHigh);
        return root;

    }
    public int find(int a[],int key){
        for(int i=0;i<a.length;i++)
            if(a[i]==key)
                return i;
        return -1;
    }
    public static void main(String args[]){
        int pre[] = {4,2,1,3,6,5,7};
        int in[] ={1,2,3,4,5,6,7};
        Solution s = new Solution();
        TreeNode root = s.buildTree(pre,in);
        System.out.println(s.zigzagLevelOrder(root));


    }
}