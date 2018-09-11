import java.util.*;
public class Solution {
      public int candy(int[] a) {
            int n  = a.length;
            if(n<=1)
                return n;
            int sum = 0;
            int b[]=new int[n];
          Arrays.fill(b,1);
            for(int i = 1;i<n;i++)
                if(a[i]>a[i-1])
                    b[i] = b[i-1]+1;
            for(int i = n-2;i>=0;i--)
                if(a[i]> a[i+1] && b[i]<=b[i+1])
                    b[i] = b[i+1]+1;
            for(int i=0;i<n;i++)
                sum+=b[i];
            return sum;
        }

}