/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)  return null;
        if(head.next==null)  return new TreeNode(head.val);
         ListNode dummy = new ListNode(-99); dummy.next = head;
        ListNode slow = head , fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            dummy = dummy.next;
        }
        dummy.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);
        root.left =  sortedListToBST(head);
        return root;
    }
}