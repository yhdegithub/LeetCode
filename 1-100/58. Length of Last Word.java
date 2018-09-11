import java.util.*;
class Solution {
    public int lengthOfLastWord(String s) {
       if(s==null)
           return 0;
        s = s.trim();
       int n =s.length();
        if(n<=1)  return n;
        int len = 1;
        for(int i=n-2;i>=0 && s.charAt(i)!=' ';i--)
              len++;
        return len;
    }
}