import java.util.*;
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s==null && t==null)
            return true;
        int n = s.length();
        if(n<=1)
            return true;
        HashMap<Character , Character> map =new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
            if(map.containsValue(t.charAt(i)))
                return false;
                map.put(ch,t.charAt(i));
            
            }
           
            if(t.charAt(i)!=map.get(ch))
                return false;
            
        }
        return true;
    }
}