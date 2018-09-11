
import java.util.*;
public class Solution {
 //递归来复制所有的结点，为避免有环的存在，必须用set检测
    HashMap<Integer,UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return null;
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        if(map.containsKey(clone.label))
            return  map.get(clone.label);
        else
            map.put(clone.label , clone);
        for(UndirectedGraphNode cur : node.neighbors){
            clone.neighbors.add(cloneGraph(cur));
        }
        return clone;
    }
}