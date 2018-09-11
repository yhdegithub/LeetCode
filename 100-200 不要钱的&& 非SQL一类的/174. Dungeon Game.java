public class Solution {
    //State: f[i][j] is from (0, 0) to (i, j) the least health the knight should have
    //Function: f[i][j] + dungeon[i][j] >= 1 --> f[i][j] = Math.max(1 - dungeon[i][j], 1);
    //Intialize: f[i][n - 1] = Math.max(1 - f[i + 1][n - 1], 1), f[m - 1][i] = math.max(i - f[m - 1][i + 1], 1);
    //Result: f[0][0];
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        
        int m = dungeon.length, n = dungeon[0].length;
        int[][] f = new int[m][n];
        //初始化最后一步的血量要求
        f[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        //最后一列格子的初始血量
        for (int i = m - 2; i >= 0; i--) {
            f[i][n - 1] = Math.max(1, f[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        //最后一排格子的初始血量
        for (int j = n - 2; j >= 0; j--) {
            f[m - 1][j] = Math.max(1, f[m - 1][j + 1] - dungeon[m - 1][j]);
        }
        //可以从右边或者下边得到当前格子的最小初始血量
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int right = Math.max(1, f[i][j + 1] - dungeon[i][j]);
                int down = Math.max(1, f[i + 1][j] - dungeon[i][j]);
                f[i][j] = Math.min(right, down);
            }
        }
        
        return f[0][0];
    }
}