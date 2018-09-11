//模拟一遍这个过程，走一圈回到起点就行，发现left<cost就不行
import java.util.*;
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       if(gas==null || gas.length==0)
           return -1;
       int n = gas.length;
       int i=0;
       int j =0;
       int left = 0;
       for(;i<n;i++){   //测试每个站点
           if(gas[i]<cost[i])   //剪枝
               continue;
             left = gas[i] - cost[i];  //从第i+1个站点开始
           j = (i+1) % n;
             for(;j!=i;j = (j+1)%n){
                  if(left<0) 
                      break;
                  left += gas[j] - cost[j];
                 if(left<0)
                     break;
             }
            if(j==i && left>=0)
                return i;
       }
       return -1;
    }
    public static void main(String args[]){
        int gas[] = {5,0,9,4,3,3,9,9,1,2};
        int cost[] ={6,7,5,9,5,8,7,1,10,5};
        System.out.println(new Solution().canCompleteCircuit(gas,cost));
    }
}