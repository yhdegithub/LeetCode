import java.util.*;
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> fizzBuzz(int n) {
        if(n<1)
            return res;
        for(int i=1;i<=n;i++){
            if((i%15)==0)
                res.add( "FizzBuzz");
            else if(((i%5)==0))
                res.add("Buzz");
            else if(((i%3)==0))
                res.add("Fizz");
            else
                 res.add(String.valueOf(i));
        }
        return res;
    }
}