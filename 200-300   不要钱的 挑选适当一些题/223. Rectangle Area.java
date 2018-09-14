import java.util.*;
class Solution {
	//找到相交的矩形部分的长和宽是关键
    public int computeArea(int x1, int y1, int x2, int y2 , int x3, int y3, int x4, int y4) {
      //方法简单，  就是面积之和 - 相交部分的面积
        long sum = (x2-x1) * (y2-y1)  + (x4-x3) *(y4 - y3);
        long cover = 0;
        //计算相交部分
         // Math.min(x2,x4) 表示右边边的最小的边
        // Math.max(x1, x3) 表示左边边的最大的边
        long wide = (long)(Math.max((long)Math.min(x2 , x4) -(long) Math.max(x1,x3) ,0));
        long height = (long)(Math.max((long)Math.min(y2 , y4) -(long) Math.max(y1,y3) ,0));
        cover  = wide * height;
        return (int)(sum -cover);
        }
}