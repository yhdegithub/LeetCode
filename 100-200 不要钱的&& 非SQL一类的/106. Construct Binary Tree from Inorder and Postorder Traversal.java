/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] in, int[] post) {
        if (in == null || in.length == 0)
            return null;
        int n = in.length;
        return dfs(in, 0, n - 1, post, 0, n - 1);
    }

    //
    public TreeNode dfs(int in[], int inLow, int inHigh, int post[], int postLow, int postHigh) {
        if (inLow > inHigh || postLow > postHigh)
            return null;
        TreeNode root = new TreeNode(post[postHigh]);
        int index = find(in, post[postHigh]);
        root.left = dfs(in,inLow,index-1,post,postLow,index-inLow-1+postLow);
        root.right = dfs(in,index+1,inHigh,post,index-inLow+postLow,postHigh-1);
        return root;
    }

    public int find(int a[], int key) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == key)
                return i;
        return -1;
    }
}