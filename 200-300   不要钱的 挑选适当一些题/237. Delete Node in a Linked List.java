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
    public void deleteNode(ListNode node) {
        //交换与后继的值，然后删除后继
       
        node.val = node.next.val;
        node.next = node.next.next; 
    }
}