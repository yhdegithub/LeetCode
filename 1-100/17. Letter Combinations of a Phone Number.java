import java.util.*;
// 回溯法。了事
class Solution {
    List<String> res = new ArrayList<>();
    HashMap<Integer, String> map = new HashMap<>();
    public List<String> letterCombinations(String s) {
        if (s == null || s.length() == 0)
            return res;
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        dfs(0, s, "");
        return res;
    }

    public void dfs(int start, String s, String one) {
        if (start >= s.length()) {
            res.add(new String(one));
            return;
        }
        int k = s.charAt(start) - '0';
        String tmp = map.get(k);
        for (int j = 0; j < tmp.length(); j++) {
            dfs(start + 1, s, one + tmp.charAt(j));

        }

    }


    public static void main(String args[]) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}