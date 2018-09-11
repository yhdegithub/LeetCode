import java.util.*;
//使用indexOf()太简单了，这里实现具体的indexOf()，以及BM算法 ， KMP算法问人吧
class Solution {
    public int strStr(String txt, String pat) {
        int res = -1;
        if(pat==null || txt==null)
            return res;
        int m = txt.length() , n = pat.length();
        int right[] = new int[256];
        Arrays.fill(right,-1);
        for(int i=0;i<n;i++)
            right[ pat.charAt(i)] = i;
        int skip = 0;
        for(int i=0;i<=m-n;i+=skip){
            skip = 0;
            for(int j=n-1;j>=0;j--){
                if(pat.charAt(j) != txt.charAt(i+j)){
                    skip = j - right[txt.charAt(i+j)];
                    if(skip<=0)
                        skip = 1;
                    break;
                }
            }
            if(skip==0)   return i;
        }
        return res;
    }
}