public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if(m<=1)    return;
        int n = board[0].length;
        if(n<=1)  return;
        //查找四周的O,并且DFS遇到的O，把之变成#
        for(int i=0;i<m;i++)
           for(int j=0;j<n;j++)
               if(  (i==0 || j==0 || i==m-1 || j==n-1) && board[i][j] =='O'){
                   board[i][j] = '#';
                   dfs(board,i,j);
               }

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(board[i][j]=='O')
                    board[i][j] = 'X';
        else if( board[i][j] =='#')
                    board[i][j] = 'O';
        else
            continue;
    }
   public void dfs(char board[][],int x,int y){
        //朝四个方向遍历
       int m = board.length;
       int n = board[0].length;
       //向下
       for(int i=x+1 ;i>=0&&i<m && y<n && y>=0&& board[i][y] =='O' ;i++){
           board[i][y] = '#';
           dfs(board ,i,y);
       }
       //向上
      for(int i = x-1;i>=0&&i<m && y<n && y>=0&& board[i][y] =='O';i--){
           board[i][y] = '#';
           dfs(board,i,y);
      }
      //向左
       for(int j=y-1;x>=0&&x<m && j<n && j>=0&& board[x][j] =='O';j--){
           board[x][j] = '#';
           dfs(board,x,j);
       }
        //向右
       for(int j=y+1;x>=0&&x<m && j<n && j>=0&& board[x][j] =='O';j++){
           board[x][j] = '#';
           dfs(board,x,j);
       }

   }
}