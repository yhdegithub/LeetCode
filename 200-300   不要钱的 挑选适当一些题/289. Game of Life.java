/**
1、这个题目的难点在于，每次既要修改当前状态，又要保存当前状态。
2、初始状态为0和1，那么变化后的状态无非有四个，{00，01，10，11}，其中高位表示下个状态，低位表示当前状态。
3、根据题目要求：
      1）、当前状态为1，活细胞少于2个，那么它就死亡了，变为01，即数字1，其实不需要改变当前值。
      2）、当前状态为1，活细胞为2或者3，它继续生存，变为11，即数字3。
      3）、当前状态为1，活细胞多余3个，死亡，变为01，还是1，不需要改变当前值。
      4）、当前状态为0，活细胞为3个，它变为活细胞，状态为10，即数字2。
4、这样统计每个细胞周围活细胞的数量，根据3的描述，值为1和3的都是活着的。
5、对每个细胞做一次这样的操作，最后右移一位即为下一个状态。

*/
public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int status = getStatus(board, m, n, i, j);
                if ((board[i][j] == 1 || board[i][j] == 3)
                        && (status == 2 || status == 3)) {
                    board[i][j] = 3;
                } else {
                    board[i][j] = status == 3 ? 2 : board[i][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
 
    private int getStatus(int[][] board, int m, int n, int x, int y) {
        int live = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int newX = x + i;
                int newY = y + j;
                if (newX == x && newY == y) {
                    continue;
                }
                if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                    if (board[newX][newY] == 1 || board[newX][newY] == 3) {
                        live++;
                    }
                }
            }
        }
        return live;
    }
}
