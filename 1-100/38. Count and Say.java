import java.util.*;
//弄懂题意
class Solution {
    public String countAndSay(int n) {
       String res = "1";
       for(int i=2;i<=n;i++){
           StringBuilder sb = new StringBuilder();
           String tmp = res;
           int j=0;
           while(j<res.length()){
               int count  = 1;
               char ch = res.charAt(j);
               while(j<res.length()-1&& res.charAt(j+1) ==ch){
                   count++;
                   j++;
               }
               j++;
                 sb.append(String.valueOf(count));
                 sb.append(ch);
           }
           res = sb.toString();
       }
       return res;
    }
    public static void main(String args[]){
        for(int i=1;i<=10;i++)
           System.out.println(new Solution().countAndSay(i));
            System.out.println(new Solution().countAndSay(3));
    }
}