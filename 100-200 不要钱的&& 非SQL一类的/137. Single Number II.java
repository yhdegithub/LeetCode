import java.util.*;
public class Solution {
      public int singleNumber(int[] A) {
        int n =A.length;
        char res[] = new char[32];
        int ans = 0;
        for(int i=0;i<32;i++){
            int flag = 1<<i;
            int count = 0;
            for(int j=0;j<n;j++)
                if( ( A[j] & flag ) != 0)
                    count++;
            if(count%3!=0)
               ans |= (1<<i) ;
        }
        
        return ans ;
    }
}