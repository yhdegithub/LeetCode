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
public class Solution
{
	public ListNode detectCycle(ListNode head)           //返回环起始结点
	  {
		  if(head==null)  return null;
		  ListNode firstMeet =  meetNode(head);   //找到第一个相遇结点
		  if(firstMeet==null)  return null;        //无环
		    ListNode p=head;                                
		  while(p!=firstMeet)     //firstMeet和head依次往后走，再次相遇即为环的起点,公式自行推导
		  {
			  p=p.next;
			  firstMeet=firstMeet.next;
			  
		  }
		   return p;
		  
	  }
	
	public ListNode  meetNode(ListNode head)
	   {
      ListNode slow=head,fast=head;
       while(fast!=null && fast.next!=null)	  
	       {
		slow =slow.next;
         fast =fast.next.next;
         if(slow==fast)  return slow;    //第一次相遇结点		 
			   
		   }
		 return null;  
	   }	
	
	
}
