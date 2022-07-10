package algorithm.p2_dichotomy.t62搜索旋转排序数组;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/62
 * 给定一个有序数组，但是数组以某个元素作为支点进行了旋转(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。
 * 给定一个目标值target进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1。
 * 你可以假设数组中不存在重复的元素。
 *
 * @author aabo
 * @createTime 2022/6/15 22:39
 */
public class Solution {
    /**
     * @param A:      an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {

        if (A == null || A.length == 0) {
            return -1;
        }

        // 先二分法找到最小值
        int minIndex = findMinIndex(A);

        // 再二分法
        if (target <= A[A.length - 1]) {
            return binarySearch(A, minIndex, A.length - 1, target);
        } else {
            return binarySearch(A, 0, minIndex - 1, target);
        }
    }

    private int binarySearch(int[] A, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == A[mid]) {
                return mid;
            }
            if (target < A[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (target == A[start]) {
            return start;
        }
        if (target == A[end]) {
            return end;
        }
        return -1;
    }

    private int findMinIndex(int[] A) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return A[start] > A[end] ? end : start;
    }

}