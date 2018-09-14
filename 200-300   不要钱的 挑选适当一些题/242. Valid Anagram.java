import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null && t==null)
            return true;
        int m =s.length() , n=t.length();
        if((m==0&&n==0))  return true;
        if(m!=n)  return false;
        char ss[] = s.toCharArray();
        Arrays.sort(ss);
        char tt[] = t.toCharArray();
        Arrays.sort(tt);
         return String.valueOf(ss).equals(String.valueOf(tt));   
    }
}