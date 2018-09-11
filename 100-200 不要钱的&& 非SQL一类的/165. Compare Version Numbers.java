import java.util.*;
class Solution {
    public int compareVersion(String v1, String v2) {
        if(v1==null&&v2==null)
            return 0;
        String s1[] = v1.split("\\.");
        String s2[] = v2.split("\\.");
        int m = s1.length ,n = s2.length;
        int i=0;
        for(;i<Math.min(m,n);i++){
            int a1 = Integer.parseInt(s1[i]);
            int a2= Integer.parseInt(s2[i]);
            if(a1>a2)
                return 1;
            else if(a1<a2)
                return -1;
        }
        while(i<n){
            int c = Integer.parseInt(s2[i]);
            if(c>0)
                return -1;
            i++;
        }
     while(i<m){
            int c = Integer.parseInt(s1[i]);
            if(c>0)
                return 1;
            i++;
        }


        return 0;
    }
    public static void main(String args[]){
        Solution s = new Solution();
        String s1 ="0.1" ;
        String s2 ="1.1" ;
        System.out.println(s.compareVersion(s1,s2));
    }
}