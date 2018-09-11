import java.util.*;

class Solution {
    List<Integer> res;

    public List<Integer> spiralOrder(int[][] a) {
        res = new ArrayList<>();
        if (a == null || a.length == 0)
            return res;
        int m = a.length, n = a[0].length;
        int colStart = 0, colEnd = m - 1;
        int rowStart = 0, rowEnd = n - 1;
        while (colStart <= colEnd && rowStart <= rowEnd) {
            int i = 0, j = 0;
            for (i = colStart, j = rowStart; colStart <= colEnd && rowStart <= rowEnd && j <= rowEnd; j++)
                res.add(a[i][j]);
            colStart++;
            for (i = colStart, j = rowEnd; colStart <= colEnd && rowStart <= rowEnd && i <= colEnd; i++)
                res.add(a[i][j]);
            rowEnd--;
            for (i = colEnd, j = rowEnd; colStart <= colEnd && rowStart <= rowEnd && j >= rowStart; j--)
                res.add(a[i][j]);
            colEnd--;
            for (i = colEnd, j = rowStart; colStart <= colEnd && rowStart <= rowEnd && i >= colStart; i--)
                res.add(a[i][j]);
            rowStart++;
        }
        return res;
    }
}
