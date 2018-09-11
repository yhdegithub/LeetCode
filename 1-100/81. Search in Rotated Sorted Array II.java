class Solution {
    public boolean search(int[] nums, int target) {
        return Position(nums,target)!=-1;
    }
   
    public int Position(int[] a, int target) {
 if (a == null || a.length == 0)
            return -1;
        int n = a.length;
        int low = 0, high = n - 1;
        while (low <= high) {
           int mid = (low + high)/2;
            if(a[mid] == target)
                return mid;
            if(a[low]<a[mid]){  //左边有序
                if(a[low]<=target && target<=a[mid])
                      high = mid;
                else
                    low = mid + 1;
            }else  if(a[low]>a[mid]){
                if(a[mid]<=target && target<=a[high])
                     low = mid+1;
                else
                    high = mid;
            }
            else
                low++;

            }


        return -1;
        }

}