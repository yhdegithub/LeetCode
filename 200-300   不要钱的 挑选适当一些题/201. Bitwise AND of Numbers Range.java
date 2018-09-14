/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        //检查m和n的高位有多少是相同的， 后面的低位就是0了
       char mm[] = new char[32];
       char nn[] = new char[32];
       make(mm,m);
       make(nn,n);
       char res[] =new char[32];
        int i=0;
       for(;i<=31&&mm[i]==nn[i];i++)
           res[i] = mm[i];
       while(i<32) res[i++] = '0';
       String ss = String.valueOf(res);
    return Integer.parseInt(ss,2);
    }
    public void make(char a[],int m){
        String s = Integer.toBinaryString(m);
        int n = s.length()-1,i =31;
        while(n>=0)
            a[i--] = s.charAt(n--);
       while(i>=0)  a[i--] = '0';
    }
    public static void main(String args[]){
        System.out.println(new Solution().rangeBitwiseAnd(5,5));
    }
}