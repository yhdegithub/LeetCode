import java.util.*;
public class Solution {
    public String simplifyPath(String path) {

     Stack<String>stack = new Stack<>();
     String ss[] = path.split("/");
     for(int i=0;i<ss.length;i++){
        if(ss[i].equals(".")|| ss[i].equals(""))
            continue;
        else if(ss[i].equals("..")){
            if(!stack.isEmpty())
                stack.pop();
        }
        else
            stack.push(ss[i]);
     }
    String res = "";
     if(stack.isEmpty())   return "/";
     while(!stack.isEmpty())
         res = "/"+stack.pop() + res;
                 return res;
    }
    public static void main(String args[]){
        String path[]={"/home/",  "/a/./b/../../c/","/../","/home//foo/", };
        for(int i=0;i<path.length;i++)
        System.out.println(path[i] + "   "+  new Solution().simplifyPath(path[i]));
    }
}