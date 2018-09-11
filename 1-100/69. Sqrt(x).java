class Solution {
    public int mySqrt(int x) {
           if(x<0)  return -1;
         if(x==0) return 0;
        if(x<=3)  return 1;
        else if(x<=8)  return 2;
        long i = 1,j =x;
        long mid = 0;
        while(true){
           mid=(i+j)/2;
            if(mid*mid<=x && (mid+1)*(mid+1)>x)
                return (int)mid;
            else if(mid*mid>x)
                j = (int)mid;
            else
                i = (int)mid;
        }
        
       // return (int)mid;
    }
    }
