//用一个map保存新旧结点的对应关系， 最后遍历一次，利用map修改random指针
import java.util.*;
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        HashMap<RandomListNode,RandomListNode>map = new HashMap<>();
        RandomListNode cur = head;
        RandomListNode dummy = new RandomListNode(-999);  //保存新的链表
        RandomListNode tail = dummy;
        while(cur!=null){
            RandomListNode tmp = new RandomListNode(cur.label);
            map.put(cur,tmp);           //旧结点  新节点
            tail.next = tmp;
            tail = tmp;
            cur = cur.next;
        }
       //接线来修改random指针
        cur = head;
        RandomListNode cur2 = dummy.next;
        while(cur2!=null){
            cur2.random = map.get(cur.random);
            cur = cur.next;
            cur2 = cur2.next;
        }
        return dummy.next;
    }
}