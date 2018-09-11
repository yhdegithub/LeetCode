/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
   public  ListNode reverseBetween(ListNode head,int m,int n)
    {
        if(m==n ||head==null)  return head;
        ListNode primer = new ListNode(0);
        primer.next=head;
        ListNode cur=primer,mark;
        int i;
        for( i=1;i<m;i++) cur=cur.next;
        ListNode head2=cur,temp;
        cur=cur.next;
        mark=cur;
        head2.next=null;
        for(i=m;i<=n;i++)
        {
            temp =cur.next;
            cur.next=head2.next;
            head2.next=cur;
            cur =temp;
        }
        mark.next=cur;
        return  primer.next;
    }
    }
