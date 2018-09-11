import java.util.*;
class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null)  return p==null;
        //p的长度为0
        if(p.length()==0)
            return s.length()==0;
        //p的长度为1
        if(p.length()==1){
            if(s.length()==1 && check(s.charAt(0), p.charAt(0)))
                return true;
            else  return false;
        }
        //p的长度>=2, 且p[1] ！= '*'
        if(p.charAt(1)!='*'){
            if(s.length()==0) return false;
            return  check(s.charAt(0), p.charAt(0)) ? isMatch(s.substring(1),p.substring(1)) : false;
        }
        //p的长度>=2 .且p[1]=='*'
        while(s.length()!=0 &&  check(s.charAt(0), p.charAt(0)) ){

            if(isMatch(s,p.substring(2)))  //p后移2位
                return true;
            s = s.substring(1);

        }

        return isMatch(s,p.substring(2));


    }
    public boolean check(char a,char b){
        return a==b || a=='.' || b=='.';
    }
}