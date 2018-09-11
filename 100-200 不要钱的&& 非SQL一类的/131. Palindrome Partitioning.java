import java.util.*;

class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null)
            return res;
        List<String> one = new ArrayList<>();
        dfs(s, 0, one);
        return res;
    }

    //典型的回溯法
    public void dfs(String s, int start, List<String> one) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(one));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String t = s.substring(start, i);
            if(!check(t))
                continue;
            one.add(t);
            dfs(s,i,one);
            one.remove(one.size()-1);
        }

    }
    //检查是否会回文
    public boolean check(String s){
        if(s==null || s.length()<=1)
            return true;
        int n = s.length();
        for(int i=0;i<n/2;i++)
            if(s.charAt(i)!=s.charAt(n-1-i))
                return false;
        return true;


    }

    public static void main(String args[]) {
        String s = "aab";
        System.out.println(new Solution().partition(s));
    }
}