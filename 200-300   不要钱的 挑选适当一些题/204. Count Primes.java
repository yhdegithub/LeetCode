import java.util.*;
class Solution {
     public static int countPrimes(int n) {
        //筛子法
        if(n==2) return 0;
        boolean a[] = new boolean[n];
        int k = (int)Math.sqrt(n) +1;
        for(int i=2;i<=k;i++)
            for(int j=2;i*j<n;j++)
                a[i*j] = true;
        int count =0;
        for(int i=2;i<n;i++)
            if(!a[i])
                count++;
        return count;
    }

}