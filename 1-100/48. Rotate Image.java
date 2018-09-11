import java.util.*;
class Solution {
    public void rotate(int[][] matrix) {
        //沿着对角线 ， 然后中线折叠
        if(matrix==null || matrix.length<=1)
            return;
        int n = matrix.length;
        //对角线
        for(int i=0;i<n;i++)
            for(int j=0;j<i;j++)
                swap(matrix,i,j);
        //中垂线
        for(int i=0;i<n;i++)
            for(int j=0;j<n/2;j++){
                int t = matrix[i][j];
                matrix[i][j] =  matrix[i][n-1-j];
                matrix[i][n-1-j] = t;
                
            }
                
    }
    public void swap(int a[][],int i,int j){
        int t = a[i][j];
        a[i][j] = a[j][i];
        a[j][i] = t;
    }
}