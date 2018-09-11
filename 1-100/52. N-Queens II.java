import java.util.*;class Solution {
    public int totalNQueens(int n) {
        return  solveNQueens(n).size();
    }
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n<=0 )
            return res;
        int pos[] =  new int[n]; // 第i排皇后位置为pos[i]
        dfs(pos , 0,n);
        return res;
    }
    //回溯法
    public void dfs(int pos[],int num,int n){
        if(num>=n){
            add(pos);
            return;
        }

        for(int i=0;i<n;i++){                // pos[num] ==0,1,2,3......sum-1
            if(!check(pos,num,i))
                continue;
            pos[num] = i;
            dfs(pos,num+1,n);
            pos[num]  = 0;
        }
    }

    //合法
    public boolean check(int pos[],int i,int target){
        //如果 pos[i]==taregt是否合法
        pos[i] = target;
        for(int j=0;j<i;j++)
            for(int k =j+1;k<=i;k++)
                if(pos[j]==pos[k] || Math.abs(j-k)==Math.abs(pos[j] - pos[k]) )
                    return false;
        return true;



    }



    //增加一个合法的
    public void add(int pos[]){
        List<String> one = new ArrayList<>();
        int n = pos.length;
        char a[][] = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(a[i],'.');
            a[i][pos[i]] = 'Q';
            one.add(String.valueOf(a[i]));
        }
        res.add(new ArrayList<>(one));
    }
    public static void main(String args[]){
        int n = 4;
        System.out.println(new Solution().solveNQueens(n));
    }
}