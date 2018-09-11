import java.util.*;

class Solution {
    List<String> res = new ArrayList<>();
    HashSet<String> set;
    public List<String> wordBreak(String s, List<String> list) {
        if(s==null||s.length()==0 || list.size()==0)
            return res;
        if( !wordBreak2(s,list))
            return res;
       set = new HashSet<>();
       for(String t: list)
           set.add(t);
        dfs(s,0,"");
        return res;
    }
    public void dfs(String s,int start,String one){
            if(start>=s.length()){
                res.add(new String(one.substring(0,one.length()-1)));
                return;
            }
            for(int i=start;i<=s.length();i++){
                String tmp = s.substring(start,i);
                if(!set.contains(tmp))
                 continue;
                one = one + tmp + " ";
                dfs(s,i,one);
                one = one.substring(0,one.length()-tmp.length()-1);
            }
    }
//剪枝
     public boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return true;
        HashMap<String, Integer> map = new HashMap<>();
        for (String t : wordDict)
            map.put(t, 1);
        /**用动态规划
         *   dp[i]代表取s的前i个元素，是否可以拼起来
         *     对于 j=0,1,2,3....i-1 , 如果s.substring(j,i)存在于map中，&& dp[j]
         *     那么dp[i] = true;
         *
         *
         */
        int n = s.length();
        boolean dp[] = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 0; j--) {
                String tmp = s.substring(j, i);
                if (dp[j] && map.containsKey(tmp))
                    dp[i] = true;
            }
        }


        return dp[n];
    }
    public static void main(String args[]) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog"); wordDict.add( "sand"); wordDict.add( "and");
        wordDict.add( "cat");
        String s = "catsanddog";
        System.out.println(new Solution().wordBreak(s, wordDict));


    }
}