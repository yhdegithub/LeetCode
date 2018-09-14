import java.util.*;
public class Solution {
	//右上角 ，左下角元素是关键
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null ||matrix.length==0)
            return false;
        int m = matrix.length , n= matrix[0].length;
        int i=0, j = n-1;
        while(0<=i&&i<m&&j>=0&&j<n){
            int dif = matrix[i][j] - target;
            if(dif==0)
                return true;
            else if(dif>0)
                  j--;
            else
                i++;           
        }
    return false;
    
    }
}