import java.util.*;
class Solution {
    //找个滑动窗口的出来，注意更新left , right出来就好
    public int lengthOfLongestSubstring(String s) {
        if(s==null) return 0;
        int n =s.length();
        if(n<=1)  return n;
        int max = 1;
        int left = 0 , right = 1;
        HashMap < Character,Integer > map  = new HashMap<>();
        map.put(s.charAt(0),0);
        while(right < n ){
            char ch = s.charAt(right);
            if( !map.containsKey(ch)){
                map.put(ch,right);
                right++;
            }else{
                max = Math.max(max,right-left);
                left = map.get(ch) + 1;
                right = left ;
                map.clear();
            }
        }
        max = Math.max(max,right-left);
        return max;
    }


}