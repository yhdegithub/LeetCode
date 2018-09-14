import java.util.*;
/**
 *  1)基于快速排序 ，找到第n/3 和 2n/3 处的数字 ，然后验证两个数字
 *
 *   2）投票算法 ， 只是计数器要维护两个了
 *
 *
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> majorityElement(int[] nums) {
        if(nums==null || nums.length==0)
            return list;
        int n = nums.length;
        if(n<=1){
            for(int i=0;i<n;i++)
                list.add(nums[i]);
            return list;
        }
        int num1  = findKth(nums ,n/3) , num2 = findKth(nums,2*n/3);
        int count1 = 0 , count2=0;
        for(int i=0;i<n;i++)
            if(nums[i]==num1)  count1++;
            else if(nums[i]==num2) count2++;
        if(count1>n/3) list.add(num1);
        if(count2>n/3&& num1!=num2) list.add(num2);
        return list;
    }
    //查找位置为k的数字
    public int findKth(int a[],int k){
        int n = a.length;
        int low = 0 , high = n-1;
        while(low<high){
            int pos = find(a,low,high);
            if(pos==k)  return a[pos];
            else if(pos>k)
                high = pos-1;
            else
                low = pos+1;
        }
        return a[low];
    }
    public int find(int a[],int low,int high){
        if(low>=high)return a[low];
        int pivot = a[low];
        while(low<high){
            while(low<high && a[high]>=pivot)  high--;
            a[low] =a[high];
            while(low<high&& a[low]<=pivot) low++;
            a[high] = a[low];
        }
        a[low] = pivot;
        return low;
    }
public static void main(String args[]){
        int a[] = {2,2};
    System.out.println(new Solution().majorityElement(a));

}
}




//投票算法 ，最后需要验证答案
public List<Integer> majorityElement(int[] nums) {
	if (nums == null || nums.length == 0)
		return new ArrayList<Integer>();
	List<Integer> result = new ArrayList<Integer>();
	int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
	for (int i = 0; i < len; i++) {
		if (nums[i] == number1)
			count1++;
		else if (nums[i] == number2)
			count2++;
		else if (count1 == 0) {
			number1 = nums[i];
			count1 = 1;
		} else if (count2 == 0) {
			number2 = nums[i];
			count2 = 1;
		} else {
			count1--;
			count2--;
		}
	}
	count1 = 0;
	count2 = 0;
	for (int i = 0; i < len; i++) {
		if (nums[i] == number1)
			count1++;
		else if (nums[i] == number2)
			count2++;
	}
	if (count1 > len / 3)
		result.add(number1);
	if (count2 > len / 3)
		result.add(number2);
	return result;
}









