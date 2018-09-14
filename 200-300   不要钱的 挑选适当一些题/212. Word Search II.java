import java.util.*;
class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        if(board==null || board.length==0)
            return ans;
        for(int i=0;i<words.length;i++)
            if(exist(board,words[i]) && !ans.contains(words[i]))
                ans.add(words[i]);
        return ans;
    }
     public boolean exist(char[][] board, String word) {
     if(board==null || board.length==0)
         return false;
      int m = board.length , n= board[0].length;
      for(int i =0;i<m;i++)
          for(int j=0;j<n;j++){
          res = false;
          if(board[i][j]==word.charAt(0)){
            boolean visit[][] = new boolean[m][n];
              visit[i][j] = true;
               dfs(board,i,j,visit,word,1);
              visit[i][j] = false;
          }

          if(res)
              return true;
          }
          return res;
    }
    //回溯
    boolean res = false;
    public void  dfs(char board[][],int i ,int j,boolean visit[][],String s,int start){
          if(start>=s.length()){
              res =  true;
              return ;
          }
        //四个方向走呗
        int m = board.length , n= board[0].length;
          //右
        if(!res && j<n-1 && !visit[i][j+1] && board[i][j+1]== s.charAt(start) ){
            visit[i][j+1] = true;
            dfs(board,i,j+1,visit,s,start+1);
            visit[i][j+1] = false;
        }
        //左
        if(!res && j>0 && !visit[i][j-1] && board[i][j-1]== s.charAt(start) ){
            visit[i][j-1] = true;
            dfs(board,i,j-1,visit,s,start+1);
            visit[i][j-1] = false;
        }
        //下
        if(!res&& i<m-1 && !visit[i+1][j] && board[i+1][j]== s.charAt(start) ){
            visit[i+1][j] = true;
            dfs(board,i+1,j,visit,s,start+1);
            visit[i+1][j] = false;
        }

        //上
        if(!res&& i>0 && !visit[i-1][j] && board[i-1][j]== s.charAt(start) ){
            visit[i-1][j] = true;
            dfs(board,i-1,j,visit,s,start+1);
            visit[i-1][j] = false;
        }

    }
}