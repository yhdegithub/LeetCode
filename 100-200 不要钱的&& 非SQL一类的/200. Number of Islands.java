import java.util.*;
class Solution {
    //就一个深度遍历,设置一个标志位，最后检查dfs次数
    public int numIslands(char[][] g) {
        if(g==null || g.length==0)
            return 0;
        int res = 0;
        int m = g.length ,n = g[0].length;
        boolean vis[][] =new boolean[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(!vis[i][j] &&g[i][j]=='1'){
                    dfs(vis,g,i,j);
                    res++;
                }

        return res;
    }
    public void dfs(boolean vis[][],char g[][],int i,int j){
        int m = g.length ,n = g[0].length;
        if(i>=m || i<0 ||j>=n ||j<0)
            return;
        if(vis[i][j] || g[i][j]!='1')
            return;
        vis[i][j] = true;
        //上下左右
        dfs(vis,g,i-1,j);
        dfs(vis,g,i+1,j);
        dfs(vis,g,i,j-1);
        dfs(vis,g,i,j+1);

    }
    public static void main(String args[]){
      char g[][] ={
                { '1','1','0','0','0'},
                { '1','1','0','0','0'},
                { '0','0','1','0','0'},
                { '0','0','0','1','1'},
        };

        System.out.println(new Solution().numIslands(g));



    }
}