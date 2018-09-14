import java.util.*;
/**
 *   这道题懂了其实很简单就是找从0开始到j的最长回文串 ， 后面的子串再逆置到之前，结果即为所求
 */
class Solution {
    public String shortestPalindrome(String s) {
        if(s==null || s.length()<=1 )
            return s;
        int n = s.length();
        if(check(s))
            return s;
        int end = n-1;
        for(int i=n-1;i>=1;i--)
            if(check(s.substring(0,i))){
                end = i;
                break;
            }


        StringBuilder sb = new StringBuilder(s.substring(end,n));

        s = sb.reverse().toString() + s;
        return s;
    }
    public boolean check(String s){
        if(s==null || s.length()<=1)
            return true;
        int n =s.length();
        for(int i=0;i<n/2;i++)
            if(s.charAt(i)!=s.charAt(n-1-i))
                return false;
        return true;


    }
    public static void main(String args[]){
        String s ="aacecaaa" ;
        System.out.println(new Solution().shortestPalindrome(s));
    }
}