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
    public ListNode rotateRight(ListNode head, int n)    //成环,就可以循环移动了
	{             
        if(head==null||head.next==null||n==0)  return head;
		ListNode cur=head,head2;
		int len=1;
		while(cur.next != null)  {  len++;  cur=cur.next;              }
         if(n==len) return head;
		 cur.next= head;
		int j=len-n%len;            //注意n可以比len要大得多，用取模
	  for(int i=1;i<j;i++)
	  {
		 head=head.next;
	  }	
	  head2=head.next;
	  head.next=null;  //新的尾巴后继要为空
	  return head2;
}
}