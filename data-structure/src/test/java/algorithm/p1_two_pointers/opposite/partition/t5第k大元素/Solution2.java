package algorithm.p1_two_pointers.opposite.partition.t5第k大元素;

import algorithm.header.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

// 最坏 O(nlog(n))
public class Solution2 {

    /**
     * @param k: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public static int kthLargestElement(int k, int[] nums) {

        PriorityQueue<Integer> integers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

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
