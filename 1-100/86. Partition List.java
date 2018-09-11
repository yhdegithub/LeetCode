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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null)
            return head;
        ListNode  small = new ListNode(x-1);
        ListNode big  = new ListNode(x+1);
        ListNode tail1 = small , tail2 = big;
        ListNode cur = head , tmp = cur.next;
        while(cur!=null){
            tmp = cur.next;
            cur.next = null;
            if(cur.val<x){
                tail1.next = cur;
                tail1 = cur;
            }else{
                tail2.next = cur;
                tail2 = cur;
            }
      cur = tmp;
        }
        cur = small;
        while(cur.next!=null)  cur = cur.next;
        cur.next = big.next;
        return small.next;
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
        int a[] ={1,4,3,2,5,2};
        int k = 3;
        ListNode head = s.build( a);
        s.partition(head,k);
    }
}