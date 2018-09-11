import java.util.*;
class Solution {
    public String intToRoman(int num) {
        if(num==0)
            return "";
        StringBuilder sb = new StringBuilder();
        String key[] ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int val[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int n =key.length;
        while(num>0){   //优先转化最大值得嘛
            for(int i=0;i<n;i++){
                if(num>=val[i]){
                    sb.append(key[i]);
                    num -= val[i];
                    break;
                }
            }
        }

        return sb.toString();
    }
}