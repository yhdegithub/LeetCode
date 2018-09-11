/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 这道题解答很多 ， 最容易想到的有三种
 *    （1）n-1次调用2-归并 ， 两两归并， 最终产生只剩一个
 *    （2） 二分归并
 *    （3）设置一个最小堆 ， 每次拿出来一个
 */
import java.util.*;
class Solution {
    //写一个二分的归并把
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        int low = 0 , high =  lists.length-1;
        return mergeList(lists,low,high);
    }
    public ListNode mergeList(ListNode[] lists,int low,int high){
        if(low>=high)
            return lists[low];
        int mid = (low+high)/2;
        ListNode l  = mergeList(lists,low,mid);
        ListNode r = mergeList(lists,mid+1,high);
        return merge(l,r);
    }
    public ListNode merge(ListNode l,ListNode r){
        if(l==null)  return r;
        if(r==null)  return l;
        if(l.val<=r.val){
            l.next = merge(l.next,r);
            return l;
        }else{
            r.next = merge(l,r.next);
            return r;
        }
    }
}