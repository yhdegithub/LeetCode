import java.util.*;
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern==null)
            return str==null;
        int n  = pattern.length();
        String ss[] = str.split(" ");
        if(n==0)
            return ss.length==0;
        int m = ss.length;
        if(m!=n)
            return false;
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = pattern.charAt(i);
            if(!map.containsKey(ch)){
                if(map2.containsKey(ss[i]))
                   return false;
                map.put(ch,ss[i]);
                map2.put(ss[i],ch);
            }else{
                if(!ss[i].equals(map.get(ch)))
                return false;

            }
        }
        return true;

    }
    public static void main(String args[]){
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(new Solution().wordPattern(pattern,str));

    }
}