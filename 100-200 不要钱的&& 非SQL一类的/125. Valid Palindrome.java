import java.util.*;
class Solution {
    public boolean isPalindrome(String s) {
        if(s==null) return false;
        s = s.trim();
        int n = s.length();
        if(n<=1)
            return true;
        int i = 0 , j = n-1 ;
        while(i<=j){
            while(i<=j && !judge(s.charAt(i)))
                  i++;
            while(i<=j && !judge(s.charAt(j)))
                  j--;
            if(i>=j)  return true;
              char pre =fun( s.charAt(i) );
              char last =fun( s.charAt(j) );
            if(pre != last )
                return false;
            else{
                i++;
                j--;
            }
            
        }
        return true;
    }
    public boolean judge(char ch){
        return ( ch>='a' && ch<='z' ) || ( ch>='A' && ch<='Z') || ( ch>='0' && ch<='9');
    }
    public Character fun(char ch){
        if(ch>='A' && ch<='Z')
            ch += 32;
        return ch;
    }
}