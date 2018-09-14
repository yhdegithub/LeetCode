/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    StringBuilder sb = new StringBuilder();
    String  t ="null,";
    public String serialize(TreeNode root) {
        if(root==null){
            sb.append(t);
            return sb.toString();
        }
        sb.append(root.val + ",");
        serialize(root.left);
        serialize(root.right);
        return sb.toString().substring(0,sb.length()-1);
    }

    // Decodes your encoded data to tree.
    int index = -1;
    String ss[];
    int n;
    public TreeNode deserialize(String data) {
         ss = data.split(",");
         n = ss.length;
       return dfs();
    }
    public TreeNode dfs(){
        index++;
        if(index>=n || ss[index].equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(ss[index]));
        root.left = dfs();
        root.right = dfs();
        return root;
    }

    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));