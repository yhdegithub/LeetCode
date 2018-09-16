import java.util.*;
class Solution {
    public String reverseString(String s) {
        if(s==null||s.length()==0)  return s;
        StringBuilder sb =new StringBuilder();
        for(int i =s.length()-1;i>=0;i--){
           char ch = s.charAt(i);
                sb.append(ch);
        }
            return sb.toString();
    }
}