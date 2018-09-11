import java.util.*;

class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null)
            return res;
        int n = s.length(), m = words.length;
        if (n == 0 || m == 0)
            return res;
        int k = words[0].length();
        if (n < m * k)
            return res;
        for (int i = 0; i <= n - m * k; i++) {
            //初始化一个map,记录words
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < m; j++)
                if (map.containsKey(words[j]))
                    map.put(words[j], map.get(words[j]) + 1);
                else
                    map.put(words[j], 1);
            //开始检查这个位置是否可以
            int count = 0;
            for (int j = i; j < i + m * k; j += k) {
                String t = s.substring(j, j + k);
                if (map.containsKey(t)) {
                    count++;
                    if (map.get(t) == 1)
                        map.remove(t);
                    else
                        map.put(t, map.get(t) - 1);
                } else
                    break;
            }
            if (count == m)
                res.add(i);

        }
        return res;
    }

    public static void main(String args[]) {
        String s = "";
        String words[] = {};
        System.out.println(new Solution().findSubstring(s, words));
    }
}