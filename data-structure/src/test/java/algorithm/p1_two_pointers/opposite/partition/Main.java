package algorithm.p1_two_pointers.opposite.partition;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        int[] nums = {9, 7, 5, 3, 1, 1, 3, 5, 7, 9};
        new Main().sortIntegers2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start, right = end;
        // key point 1: pivot is the value, not the index
        int pivot = A[(start + end) / 2];
        // key point 2: every time you compare left & right, it should be
        // left <= right not left < right
        while (left <= right) {
            // 等于pivot的往右边运
            while (left <= right && A[left] < pivot) {
                left++;
            }
            // 等于pivot的往左边运
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}