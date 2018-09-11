import java.util.*;

//典型的回溯法
public class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }
    //不断回溯
    public boolean dfs(char board[][], int count) {
      if(count>=81)
          return true;
      int x=count/9 , y = count%9;
      if(board[x][y]!='.'){
         if( dfs(board,count+1) )
                  return true;
            else
                return false;
        }
      for(char k = '1';k<='9';k++){
          if(check(board,k,x,y)){
             board[x][y] = k;
              if(dfs(board,count+1))
                return true;
              board[x][y] = '.';
          }
      }
      return false;//???????????????????????????????????????????????????
    }

    //合法检测
    public boolean check(char board[][], char k, int x, int y) {
        //检查行和列
        for (int i = 0; i < 9; i++)
            if (board[i][y] == k || board[x][i] == k)
                return false;
        //检查小九宫格
        int xx = x / 3 * 3;
        int yy = y / 3 * 3;
        for (int i = xx; i < xx + 3; i++)
            for (int j = yy; j < yy + 3; j++)
                if (board[i][j] == k)
                    return false;
        return true;

    }

    public static void main(String args[]) {
        char board[][] = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        new Solution().solveSudoku(board);
    }
}