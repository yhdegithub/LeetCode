import java.util.*;
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null ||strs.length==0)
            return res;
        int n = strs.length;
        HashMap<String,Integer> map = new HashMap<>();  //每个字符串可能出现多次
        for(String str:strs)
            if(map.containsKey(str))
                map.put(str,map.get(str)+1);
            else
                map.put(str,1);
        String copy[] = new String[n]  ;  //新旧字符串对应关系
        int i=0;
        for(String str:strs){
            char tmp[] = str.toCharArray();
            Arrays.sort(tmp);
            copy[i++] = String.valueOf(tmp);
        }
        boolean vis[] =new boolean[n];
        //添加结果,map遍历时候需要用iterator
        for(i=0;i<n;i++){
            if(vis[i])
                continue;
            List<String> one = new ArrayList<>();
            for(int j=i;j<n;j++){
                if(copy[j].equals(copy[i])){
                    one.add(strs[j]);
                    vis[j] = true;
                }

            }
            res.add(new ArrayList<>(one));

        }
        return res;
    }
    public static void main(String args[]){
        String ss[] = {"eat", "tea","tea","bat","tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution().groupAnagrams(ss));
    }
}