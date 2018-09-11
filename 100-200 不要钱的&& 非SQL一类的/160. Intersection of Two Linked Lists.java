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
import java.util.*;
public class Solution {
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        if(A==null || B==null)
            return null;
        int l1 = getLen(A) , l2 = getLen(B);
        if(l1>l2 )   return getIntersectionNode(B,A); //l2要长一些
        int dif = l2 - l1;
        for(int i=0;i<dif;i++)
            B = B.next;
        while(B!=A){
            B = B.next;
            A= A.next;
        }
        return B;

    }
    public int getLen(ListNode head){
        int len = 0;
        while(head!=null){
            len++;
            head =head.next;
        }
        return len;
    }
}