import java.util.*;

class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0)
            return "";
        s= s.trim();
        int n=s.length();
        if(n==0)
            return "";
        String ss[] = s.split(" ");
        StringBuilder sb =new StringBuilder();
        for(int i=ss.length-1;i>=0;i--){
            if(!ss[i].equals("")){
                sb.append(ss[i]);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public static void main(String args[]){
        String s = "   a   b ";
        System.out.println(new Solution().reverseWords(s));
    }
}