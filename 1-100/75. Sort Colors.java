import java.util.*;
public class Solution {
    public void sortColors(int[] A) {
        if(A==null || A.length<=1)
            return;
        int n =A.length;
        int i0=0, i2=n-1;
         for(int i=0;i<n&&i<=i2;i++){
             if(A[i]==1)  continue;
             if(A[i]==0)
                 swap(A,i,i0++);
             else
                 swap(A,i--,i2--);
         }
    }
    public void swap(int a[],int i,int j){
        int t =a[i];
        a[i] =a[j];
        a[j] = t;
    }
}