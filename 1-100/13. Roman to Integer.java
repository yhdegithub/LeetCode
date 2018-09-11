import java.util.*;
//情况是优先的，所以比较水
class Solution {
    public int romanToInt(String s) {
        if(s==null ||s.length()==0)
            return 0;
        int n=s.length();
        int map[] = new int[256];
        map['I'] = 1; map['V'] =5; map['X'] = 10;map['L'] =50; map['C'] = 100; map['D'] = 500;map['M']=1000;
        int res = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            switch (ch){
                case 'I':

                    if(i<n-1 && s.charAt(i+1)=='V')  {
                        res+=4;
                        i++;
                    }
                    else
                    if(i<n-1&& s.charAt(i+1)=='X') {
                        res+=9;
                        i++;
                    }

                    else
                        res +=1;
                    break;
                case 'X':
                    if(i<n-1 && s.charAt(i+1)=='L')  {
                        res+=40;
                        i++;
                    }
                    else
                    if(i<n-1&& s.charAt(i+1)=='C')  {
                        res+=90;
                        i++;
                    }

                    else
                        res +=10;
                    break;
                case 'C':
                    if(i<n-1 && s.charAt(i+1)=='D') {
                        res+=400; i++;
                    }
                    else
                    if(i<n-1&& s.charAt(i+1)=='M') {
                        res+=900;
                        i++;
                    }

                    else
                        res +=100;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'L':
                    res+=50;
                    break;
                case 'D':
                    res+=500;
                    break;
                case 'M':
                    res+=1000;
                    break;

            }

        }
        return res;
    }
