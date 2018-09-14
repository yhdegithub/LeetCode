import java.util.*;
class Solution {
    public String getHint(String s, String t) {
        if(s==null || s.length()==0)
            return "";
        //计算 bull
        int n = s.length();
        int A = 0 ,B = 0;
        for(int i=0;i<n;i++)
            if(s.charAt(i)==t.charAt(i))
                A++;
        //计算 cow
        HashMap<Character,Integer>map = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch))
                map.put(ch,map.get(ch)+1);
            else
                map.put(ch,1);
        }
        for(int i=0;i<n;i++){
            char ch = t.charAt(i);
            if(map.containsKey(ch)){
                B++;
                if(map.get(ch)==1)
                    map.remove(ch);
                else
                    map.put(ch,map.get(ch)-1);
            }

        }
        B = B-A;
        StringBuilder sb = new StringBuilder();
       sb.append(A);
            sb.append('A');
       sb.append(B);
            sb.append('B');
        return sb.toString();

    }
    public static void main(String args[]){
        String s ="1123";  // "1123"
        String t =  "0111";//"0111"
        System.out.println(new Solution().getHint(s,t));
    }
}