import java.util.ArrayList;
import java.util.List;
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n==0)
            return res;
        dfs("",0,0,n);
        return res;
    }
    public void dfs(String s,int l,int r,int n){   // 左右括号数目也带入，回溯
        if(l>=n&&r>=n){
            res.add(new String(s));
            return ;
        }
        if(l<n)
            dfs(s+"(",l+1,r,n);
        if(l>r)
            dfs(s+")",l,r+1,n);

    }
}