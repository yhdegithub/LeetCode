import java.util.*;
public class Solution {
    List<Integer> res;
    public List<Integer> grayCode(int n) {
          res = new ArrayList<>();
         res.add(0);  
        if(n==0){
             
               return res;
          }
             
         res.add(1);
        if(n==1)
            return res;
          for(int i=2;i<=n;i++){
              int j =(int)Math.pow(2,i-1)-1;
              int tmp = (int)Math.pow(2,i-1);
              int k = (int)Math.pow(2,i-1);
            for(;k<2*tmp;k++){
                res.add(res.get(j--) +tmp );
            }
          }
    return res;
    }
}