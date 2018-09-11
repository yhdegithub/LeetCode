import java.util.*;

class Solution {
    boolean res = false;
    boolean vis[][];
    int m;
    int n;

    public boolean exist(char[][] a, String word) {
        if (a == null || a.length == 0)
            return false;
        m = a.length;
        n = a[0].length;
        vis = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (a[i][j] == word.charAt(0)) {
                    vis[i][j] = true;
                    dfs(i, j, 1, word, a);
                    vis[i][j] = false;
                }

                if (res) return true;
            }
        return res;
    }

    //回溯法
    public void dfs(int x, int y, int start, String s, char a[][]) {
        if (start >= s.length()) {
            res = true;
            return;
        }
        //上
        if (x > 0 && !res && !vis[x - 1][y] && s.charAt(start) == a[x - 1][y]) {
            vis[x - 1][y] = true;
            dfs(x - 1, y, start + 1, s, a);
            vis[x - 1][y] = false;
        }
        //下
        if (x < m-1 && !res && !vis[x + 1][y] && s.charAt(start) == a[x + 1][y]) {
            vis[x + 1][y] = true;
            dfs(x + 1, y, start + 1, s, a);
            vis[x + 1][y] = false;
        }
        //左
        if (y > 0 && !res && !vis[x][y - 1] && s.charAt(start) == a[x][y - 1]) {
            vis[x][y - 1] = true;
            dfs(x, y - 1, start + 1, s, a);
            vis[x][y - 1] = false;
        }
        //右
        if (y < n-1 && !res && !vis[x][y + 1] && s.charAt(start) == a[x][y + 1]) {
            vis[x][y + 1] = true;
            dfs(x, y + 1, start + 1, s, a);
            vis[x][y + 1] = false;
        }

    }

    public static void main(String args[]) {
        char a[][] = {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };
        String s1 = "abcced";
        String s2 = "see";
        String s3 = "abcb";
         System.out.println(new Solution().exist(a, s1));
         System.out.println(new Solution().exist(a, s2));
       // System.out.println(new Solution().exist(a, s3));
    }
}