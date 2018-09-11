
import java.util.*;
class Solution {
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        if(root==null)
            return res;
      Stack<TreeNode > stack = new Stack<>();
      TreeNode cur = root;
      while(cur!=null || !stack.isEmpty()){
          while(cur != null){
              stack.push(cur);
              cur = cur.left;
          }
          cur = stack.pop();
          res.add(cur.val);
          cur = cur.right;

      }
      return res;
    }
    public static void main(String args[]){
        TreeNode node1 = new TreeNode(1); TreeNode node2 = new TreeNode(2); TreeNode node3 = new TreeNode(3); TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5); TreeNode node6 = new TreeNode(6); TreeNode node7 = new TreeNode(7);
        node4.left = node2;node4.right=node6;node2.left=node1;node2.right=node3;node6.left=node5;node6.right=node7;
        System.out.println(new Solution().inorderTraversal(node4));
    }
}