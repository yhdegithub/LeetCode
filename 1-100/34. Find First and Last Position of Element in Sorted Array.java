import java.util.*;

class Solution {

    public int[] searchRange(int[] A, int target) {
        int[] range = new int[2];
        range[0] = searchleft(A, target);
        range[1] = searchright(A, target);
        return range;
    }

    public int searchleft(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target == A[mid]) {
                if (mid == 0 || A[mid - 1] < target) {
                    return mid;
                }
                high = mid - 1;
            } else if (target < A[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int searchright(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target == A[mid]) {
                if (mid == A.length - 1 || A[mid + 1] > target) {
                    return mid;
                }
                low = mid + 1;
            } else if (target < A[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}