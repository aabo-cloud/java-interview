package algorithm.p2_dichotomy.t75寻找峰值;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/75
 * 给定一个整数数组(size为n)，其具有以下特点：
 * 相邻位置的数字是不同的
 * A[0] < A[1] 并且 A[n - 2] > A[n - 1]
 * 假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
 *
 * @author aabo
 * @createTime 2022/6/15 22:42
 */
public class Main {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {

        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid - 1]) {
                end = mid;
            } else if (A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                return mid;
            }
        }
        return A[start] > A[end] ? start : end;

    }
}