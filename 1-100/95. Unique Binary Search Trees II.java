/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
import java.util.*;
//Unique Binary Search Trees II
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0)  
            return new ArrayList<TreeNode>();
        return creatTree(1, n);
    }

    public List<TreeNode> creatTree(int low, int high) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (low > high) {
         res.add(null);
            return res;
        }
        for (int i = low; i <= high; i++) {
           List<TreeNode> left = creatTree(low, i - 1);
            List<TreeNode> right = creatTree(i + 1, high);
            for (int j = 0; j < left.size(); j++)
                for (int k = 0; k < right.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    res.add(root);

                }
        }  //end for
        return res;
    }
}