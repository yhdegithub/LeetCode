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
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null)  return res;
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            List <Integer> list =new ArrayList<>();
            int n=queue.size();
            for(int i=0;i<n;i++)
            {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left!=null)  queue.offer(temp.left);
               if(temp.right!=null)  queue.offer(temp.right);
            }  //end for
            res.add(list);
        }//end while
        //交换顺序
         int n=res.size();
    for(int i=0;i<n/2;i++)
    {
       List<Integer> temp =res.get(i);
        res.set(i,res.get(n-1-i) );
        res.set(n-1-i,temp);


    }
     return res;   
    }
}













