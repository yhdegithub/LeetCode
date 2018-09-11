import java.util.*;
class Solution {
    public void merge(int[] num1s, int m, int[] num2s, int n) {
        int i=m-1, j = n-1, k=m+n-1;
        while(i>=0 && j>=0){
            if(num1s[i]>=num2s[j])
                num1s[k--] = num1s[i--];
            else
               num1s[k--] = num2s[j--];   
        }
        while(i>=0)
             num1s[k--] = num1s[i--];
            while(j>=0)
      num1s[k--] = num2s[j--]; 
    }
}