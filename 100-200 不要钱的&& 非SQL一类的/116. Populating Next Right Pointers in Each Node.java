//这道题可以用层次遍历，但是空间为O(lgN)，可以假设上一层的链表已经设置完成 ， 现在用这个链表来模拟普通的队列
import java.util.*;
public class Solution {
    public void connect(TreeLinkNode root) {
         if(root==null || (root.right==null &&root.left==null))
             return ;
        TreeLinkNode lastLevecur = root;  //上一层的首节点
        TreeLinkNode  cur =  null;  //当前要修改层的cur结点
        while(lastLevecur!=null){
            //修改当前一层
            TreeLinkNode dummy = new TreeLinkNode(-9999);
            TreeLinkNode tail = dummy;
            while(lastLevecur!=null){
                if(lastLevecur.left!=null){
                    tail.next = lastLevecur.left;
                    tail = tail.next;
                }
                if(lastLevecur.right!=null){
                    tail.next = lastLevecur.right;
                    tail = tail.next;
                }
                lastLevecur = lastLevecur.next;
            }
            //当前层修改完毕， 修改lastLevecur
            lastLevecur = dummy.next;
        }


    }
    public static void main(String args[]) {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;//  node2.right = node4;
        node3.left = node5;
        node3.right = node6;
        new Solution().connect(node1);
    }
}