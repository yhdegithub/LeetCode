import java.util.*;
class Solution {
    public String getPermutation(int n, int k) {
        k--;
        int fac[] = new int[n+1];
        fac[0] = 1;fac[1]=1;
        for(int i=2;i<=n;i++)
            fac[i] =fac[i-1] *i;
        int j =n-1;
        boolean vis[] =new boolean[n+1];
        StringBuilder sb = new StringBuilder();
        while(sb.length()!=n){
            int t = k/fac[j];
            int tmp = findkth(vis,t);
            k = k %fac[j--];
            sb.append(tmp);
        }
        return sb.toString();
    }
    //前面有k个数字
    public Integer findkth(boolean vis[],int k){
        int i=0;
        int j = 1;
        while(i<=k){
            if(!vis[j++])
                i++;
        }
        vis[j-1] = true;
        return j-1;

    }
    public static void main(String args[]){

        int n =4;
        int k =18;
        for(int i=1;i<=24;i++)
        System.out.println("第"+ i + "个：" + new Solution().getPermutation(n,i));



    }

}