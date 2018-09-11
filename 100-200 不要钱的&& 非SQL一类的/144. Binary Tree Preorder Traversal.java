/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
    //稍微难一点的后序遍历
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res =new ArrayList<Integer>();
            if(root==null)
                return res;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode  cur = root , pre =null;
            while(cur!=null || !stack.isEmpty()){
                while(cur!=null){
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.peek();
                if(cur.right==null || pre==cur.right){
                    cur = stack.pop();
                    res.add(cur.val);
                    pre = cur;
                    cur =null;
                }
                else
                    cur = cur.right;
            }
            return res;
        }
}