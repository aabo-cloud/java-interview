package p1_two_pointers.opposite.partition.t64合并排序数组简单版;

public class Main {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here

        int i = m - 1, j = n - 1;
        int cur = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[cur--] = A[i--];
            } else {
                A[cur--] = B[j--];
            }
        }
        while (i >= 0) {
            A[cur--] = A[i--];
        }
        while (j >= 0) {
            A[cur--] = B[j--];
        }

    }
}