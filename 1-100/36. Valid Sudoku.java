import java.util.*;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length!=9 || board[0].length!=9)
            return false;
        int n = 9;
        //检查行
        for(int i=0;i<n;i++){
            HashSet<Integer> set=  new HashSet<>();
            for(int j=0;j<n;j++){
                if(board[i][j]=='.')
                    continue;
                else if(!set.contains(board[i][j]-'0'))
                    set.add(board[i][j]-'0');
                else
                    return false;
            }
        }
        //检查列
        for(int j=0;j<n;j++){
            HashSet<Integer> set=  new HashSet<>();
            for(int i=0;i<n;i++){
                if(board[i][j]=='.')
                    continue;
                else if(!set.contains(board[i][j]-'0'))
                    set.add(board[i][j]-'0');
                else
                    return false;
            }
        }
        //检查小九宫格
        for(int k=0;k<n;k++){ //一共九个小九宫格
            //第k个九宫格的x，y坐标
            HashSet<Integer> set=  new HashSet<>();
            for (int i = k/3 *3; i < k/3*3 + 3; i++)
                for(int j=(k%3) *3;j<(k%3) *3+3;j++){
                    if(board[i][j]=='.')
                        continue;
                    else if(!set.contains(board[i][j]-'0'))
                        set.add(board[i][j]-'0');
                    else
                        return false;
                }

        }

        return true;

    }
}