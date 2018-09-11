/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;
//把这个链表分成两部分 ， 一部分小于x，另一部分>=x
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode dummy = new ListNode(-9999999);
       dummy.next = head;
        ListNode cur = head.next , tail  = head, pre=dummy;
        head.next = null;
        while(cur!=null){
            //保存后继结点
            ListNode tmp = cur.next;
            cur.next = null;
            if(cur.val>=tail.val){
                tail.next = cur;
                tail = cur;
                cur = tmp ;
                continue;
            }
            //找到正确的插入位置
            pre =  dummy;
            while(pre!=null&&pre.next!=null && pre.next.val<=cur.val)
                pre = pre.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = tmp;
        }
        return dummy.next;
    }
    public ListNode build(int a[]){
        int n=a.length;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for(int i=0;i<n;i++){
            ListNode t = new ListNode(a[i]);
            tail.next = t;
            tail = t;
        }
        return dummy.next;
    }
    public static void main(String args[]){
        Solution s= new Solution();
        int a[] ={4,2,1,3};
        int k = 3;
        ListNode head = s.build( a);
        s.insertionSortList(head);
    }
}