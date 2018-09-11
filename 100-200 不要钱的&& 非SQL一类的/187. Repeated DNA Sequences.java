import java.util.*;
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> findRepeatedDnaSequences(String s) {
        if(s==null || s.length()<11)
            return res;
        int n=s.length();
        HashMap <String,Integer> map  =new HashMap<>();
        for(int i=0;i<=n-10;i++){
            String t = s.substring(i ,i+10);
            if(map.containsKey(t))
                map.put(t,map.get(t)+1);
            else
                map.put(t,1);
        }
        for(String t:map.keySet())
            if(map.get(t)>=2)
                res.add(t);
        return res;
    }
    //主函数
    public static void main(String args[]) {
        char board[][] = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        String s = "AAAAAAAAAAA";
        System.out.println(new Solution().findRepeatedDnaSequences(s));
    }
}