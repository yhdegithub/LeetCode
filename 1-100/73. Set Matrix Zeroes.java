/*
  既然遇到一个0就要把这一行这一列都变成0 我们不妨[i][j]==0时候，把第一行第一列的对应[i][0] = 0 [0][j] =0;第一行第一列单独判断不就好了吗？？这样常量空间复杂度



*/
import java.util.*;
public class Solution {
     public void setZeroes(int[][] a) {
            int m = a.length,n=a[0].length;
            if(m==0 || n==0)
                return;
            //判断第一行第一列,是否置0
            boolean first_col = false , first_row=false;
            for(int i=0;i<m&&!first_row;i++)
                if(a[i][0]==0)
                    first_row = true;
            for(int j=0;j<n&&!first_col;j++)
                if(a[0][j]==0)
                    first_col = true;
            //开始判断后续的数字（1,1）、、、（m-1,n-1）
            for(int i=1;i<m;i++)
                for(int j=1;j<n;j++){
                    if(a[i][j]==0){
                        a[i][0] = 0;
                        a[0][j] = 0;
                    }
                }
            //置0
            //非第一行第一列的数字看是否置0
            for(int i=1;i<m;i++){
                if(a[i][0]==0){
                    for(int j=0;j<n;j++)
                        a[i][j] = 0;
                }
            }
            for(int j=1;j<n;j++){
                if(a[0][j]==0){
                    for(int i= 0;i<m;i++)
                        a[i][j] = 0;
                }
            }
            //第一行列置零
            if(first_col)
                for(int j=0;j<n;j++)
                    a[0][j] = 0;
            if(first_row)
                for(int i=0;i<m;i++)
                    a[i][0] =0;

        }
}