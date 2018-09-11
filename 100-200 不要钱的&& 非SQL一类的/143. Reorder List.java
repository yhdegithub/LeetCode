/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;
public class Solution {
   //转化成L0 Ln L1 Ln-1.....的形式
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {  //中间节点
            slow = slow.next;
            fast = fast.next.next;
        }
        //中间节点之后的结点翻转过来
        ListNode cur = slow.next;
        slow.next = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = slow.next;
            slow.next = cur;
            cur = temp ;
        }
        ListNode head2 = slow.next, head1 = head;
        slow.next = null;
        //交错的合并两个链表
        ListNode tail = head1;
        head1 = head1.next;
        while (head1 != null&&head2!=null) {
            ListNode t1 = head1.next, t2 = head2.next;
            head1.next = null;
            head2.next = null;
            tail.next = head2;
            tail = head2 ;
            tail.next = head1;
            tail = head1;
            head1 = t1;
            head2 = t2;
        }
        if(head1!=null)
            tail.next = head1;

    }
}