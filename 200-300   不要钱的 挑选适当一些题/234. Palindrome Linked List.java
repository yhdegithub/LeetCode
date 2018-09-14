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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        //找到中间节点 ， 然后原地反转后半个链表
        int n = getLength(head);
        ListNode mid = head;
        for(int i=0;i<(n+1)/2;i++)
                mid = mid.next;
        mid = reverse(mid);
        while(mid!=null){
            if(mid.val!=head.val)
                return false;
            mid = mid.next;
            head =head.next;
        }
        return true;
    }
    //链表长度
    public int getLength(ListNode head){
        int len = 0;
        while(head!=null){
            head = head.next;
            len++;
        }
        return len;
    }
    //链表原地转置
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode dummy = new ListNode(-99);
        ListNode p = head ,q = p;
        while(p!=null){
            q = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p =q;
        }
        return dummy.next;
    }
    //建立链表
    public ListNode build(int a[]){
        int n =a.length;
        ListNode dummy = new ListNode(-99);
        ListNode tail = dummy;
        for(int i=0;i<n;i++){
            ListNode t = new ListNode(a[i]);
            tail.next = t;
            tail = t;
        }
        return dummy.next;
    }
    public static void main(String args[]){
        int a[] ={1,2,3,43,2,1};
        Solution s=  new Solution();
        ListNode head = s.build(a);
        System.out.println(s.isPalindrome(head));
    }
}