/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public ListNode removeElements(ListNode head, int val) {
          if(head==null)
              return null;
        ListNode dummy = new ListNode(val-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre!=null && pre.next!=null){
            while(pre!=null&&pre.next!=null&&pre.next.val==val){
                pre.next =pre.next.next; 
            }
            pre = pre.next;
        }
        return dummy.next;
    }
}