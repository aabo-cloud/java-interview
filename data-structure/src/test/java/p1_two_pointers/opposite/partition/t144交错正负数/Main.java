package p1_two_pointers.opposite.partition.t144交错正负数;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/144
 * 给出一个含有正整数和负整数的数组，重新排列成一个正负数交错的数组。
 *
 * @author aabo
 * @createTime 2022/6/13 13:10
 */
public class Main {
    /**
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        int negCnt = partition(A);
        int posCnt = A.length - negCnt;
        int left = (negCnt > posCnt) ? 1 : 0;
        int right = A.length - (negCnt >= posCnt ? 1 : 2);
        interleave(A, left, right);
    }

    private int partition(int[] A) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            while (left <= right && A[left] < 0) {
                left++;
            }
            while (left <= right && A[right] > 0) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
        }
        return left;
    }

    private void interleave(int[] A, int left, int right) {
        while (left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left += 2;
            right -= 2;
        }
    }

}