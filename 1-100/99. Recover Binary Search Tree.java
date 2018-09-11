import java.util.*;

class Solution {
    public void recoverTree(TreeNode root) {
        if(root==null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root,pre = null;
        TreeNode first = null , second = null;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
                cur = stack.pop();
                if(pre!=null&&cur!=null) {
                    if (first == null && cur.val < pre.val)
                        first = pre;
                    if (first != null  && cur.val < pre.val)
                        second = cur;
                }

                pre = cur;
                cur = cur.right;

            }
        //改变
        int t = first.val;
        first.val = second.val;
        second.val = t;

    }




//
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
    public static void main(String args[]) {
      int pre[] = {1,3,2};
      int in[]={3,2,1};
      Solution s= new Solution();
      TreeNode root= s.buildTree(pre,in);
      s.recoverTree(root);

    }
}