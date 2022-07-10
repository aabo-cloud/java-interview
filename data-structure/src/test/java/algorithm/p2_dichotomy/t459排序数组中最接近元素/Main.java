package algorithm.p2_dichotomy.t459排序数组中最接近元素;

/**
 * https://www.lintcode.com/problem/460
 * 在一个排好序的数组 A 中找到 i 使得 A[i] 最接近 target
 * 如果数组中没有元素，则返回-1。
 * Created by IntelliJ IDEA.
 *
 * @author aabo
 * @createTime 2022/6/15 21:49
 */
public class Main {
    /**
     * @param A:      an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    public int closestNumber(int[] A, int target) {


        if (A == null || A.length == 0) {
            return -1;
        }

        if (A.length == 1) {
            return 0;
        }

        int start = 0, end = A.length - 1;
        while (start + 1 < end) {

            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }

        }

        if (A[start] == target) {
            return start;
        }

        if (A[end] == target) {
            return end;
        }

        return Math.abs(A[start] - target) <= Math.abs(A[end] - target) ? start : end;

    }
}
