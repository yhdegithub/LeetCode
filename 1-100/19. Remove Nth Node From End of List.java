/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }  
 * 可以想得到长度 ， 也可以双指针法
 */
import java.util.*;
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        int len = 0;
        ListNode  fast= head ,slow = head;;
        for(int i=0;i<n;i++)
            fast = fast.next;
        if(fast==null) return head.next;
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}