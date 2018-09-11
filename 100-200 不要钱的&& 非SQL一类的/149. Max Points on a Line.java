/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
import java.util.*;
class Solution {
    public int maxPoints(Point[] p) {
        if(p==null) return 0;
        int n  = p.length;
        if(n<=2)
            return n;
        int max = 2;
        for(int i=0;i<n-1;i++){
            int count = 1;
            int repeat = 0;
            //先计算重复的元素
            for(int j=0;j<n;j++){
                if(j==i)  continue;
                if(p[i].x==p[j].x && p[i].y==p[j].y)
                    repeat++;
            }
            //计算不同的
            for(int j=i+1;j<n;j++){
                if(p[i].x==p[j].x && p[i].y==p[j].y)
                    continue;
                count =2;
                int x1 = p[j].x - p[i].x , y1 = p[j].y -p[i].y;
                for(int k =j+1;k<n;k++){
                    if(p[i].x==p[k].x && p[i].y==p[k].y)
                        continue;
                    int x2 = p[k].x - p[i].x , y2 = p[k].y -p[i].y;
                    long k1 = (long)x1*(long)y2 , k2 =(long) x2*(long)y1;
                    if(k1==k2)
                        count++;
                    max=  Math.max(max, repeat+count);
                }
            }

       max=  Math.max(max, repeat+count);
        }
        return max;
    }
    public static void main(String args[]){
        Point p[] = {new Point(0,0),new Point(1,65536),new Point(65536,0) };  //[[0,0],[1,65536],[65536,0]]
        System.out.println(new Solution().maxPoints(p));
    }
}