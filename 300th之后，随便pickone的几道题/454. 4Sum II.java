import java.util.*;
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n1= A.length , n2=B.length  ,n3 = C.length , n4 = D.length;
        HashMap<Long,Integer> map  =new HashMap<>();
        for(int i=0;i<n1;i++)
            for(int j=0;j<n2;j++){
                long sum = A[i] +B[j];
                if(map.containsKey(sum))
                    map.put(sum,map.get(sum)+1);
                else
                    map.put(sum,1);
            }

        HashMap<Long,Integer> map2  =new HashMap<>();
        for(int i=0;i<n3;i++)
            for(int j=0;j<n4;j++){
                long sum = C[i] +D[j];
                if(map2.containsKey(sum))
                    map2.put(sum,map2.get(sum)+1);
                else
                    map2.put(sum,1);
            }
        int res = 0;
        for(Long key : map.keySet()){
            if(map2.containsKey(-key)){
                res += map.get(key)  * map2.get(-key);
            }


        }
        return res;

    }
    /**
     * [1,1,-1,-1]
     [-1,-1,1,1]
     [1,-1,0,-1]
     [1,1,-1,1]
     *
     * **/

    public static void main(String args[]){
        int A[] ={1,1,-1,-1};
        int B[] ={-1,-1,1,1};
        int C[] = {1,-1,0,-1};
        int D[] = {1,1,-1,1};
        System.out.println(new Solution().fourSumCount(A,B,C,D));
    }
}