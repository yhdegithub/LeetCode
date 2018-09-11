import java.util.*;
public class Solution {
   List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
   if(s==null || s.length()<=3)
       return res;
    dfs(s,0,"",0);
    return res;
    }
    //回溯法
    public void dfs(String s,int start , String one,int count){
        //出口考虑完全
        if(count==4 && start==s.length()){
            if(!res.contains(one.substring(0,one.length()-1)))
            res.add(new String(one.substring(0,one.length()-1)));
            return;
        }
        if(count>4 || start>s.length())
            return;
        //子递归
        for(int i= start+1;i <= Math.min(s.length(),start+3);i++){
            String tmp = s.substring(start,i);
            int d = Integer.parseInt(tmp);
            if(d>255)
                continue;
            if(tmp.charAt(0)=='0' && i-start>1)
                continue;
            tmp = String.valueOf(d);
            one +=  tmp + "." ;
            dfs(s,i,one,count+1);
             one = one.substring(0,one.length()-tmp.length()-1);
        }
//["0.1.0.010","0.1.0.10","0.1.001.0","0.10.0.10","0.10.01.0","0.100.1.0","01.0.0.10","01.0.01.0","01.0.1.0","010.0.1.0"]
    }
//"0.10.0.10","0.100.1.0"
    public static void main(String args[]){
       String s[] = { "010010","25525511135"  ,"0000","00000","000000001"};  //      "255.255.11.135",           "255.255.111.35"
        for(int i=0;i<s.length;i++)
        System.out.println(new Solution().restoreIpAddresses(s[i]));
}
}