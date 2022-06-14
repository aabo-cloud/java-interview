package p1_Two_Pointers.opposite.partition.t5第k大元素;

import header.Heap;

// 最坏 O(nlog(n))
public class Solution2 {

    /**
     * @param k: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public static int kthLargestElement(int k, int[] nums) {

        Heap heap = new Heap();
        for (int i = 0; i < nums.length; i++) {
            heap.offer(i, nums[i]);
        }
        int kth = -1;
        while (k-- > 0) {
            kth = heap.poll().value;
        }
        return kth;

    }

    public static void main(String[] args) {
        int[] test = {0, 1, 2, 3, 4, 5, 6};
        System.out.println(kthLargestElement(3, test));
    }

}
