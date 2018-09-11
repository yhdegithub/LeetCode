/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//这道题说白了就是二叉树的中序遍历，用栈来模拟
public class BSTIterator {
     Stack<TreeNode>stack ;
    TreeNode cur ;
    public BSTIterator(TreeNode root) {
        stack =new Stack<>();
        this.cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !(stack.isEmpty() && cur==null);
    }

    /** @return the next smallest number */
    public int next() {
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
       TreeNode tmp = stack.pop();
        cur = tmp.right;
        return tmp.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */