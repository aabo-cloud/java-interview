package p1_two_pointers.opposite.partition.t148颜色分类;

import org.junit.Test;

import java.util.Arrays;

public class Solution3 {

    @Test
    public void test() {
        int nums[] = {1, 0, 1, 0, 2, 0, 1};
        // 0, 1, 1, 0, 2, 0, 1
        // 0, 0, 1, 1, 2, 0, 1
        // 0, 0, 0, 1, 2, 1, 1
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }
        partition(nums, 1);
        partition(nums, 2);
    }

    // 同向双指针做法 简洁明了
    private void partition(int[] nums, int k) {
        int lastSmallPointer = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                lastSmallPointer++;
                swap(nums, lastSmallPointer, i);
            }
        }
    }

    private void swap(int[] nums, int pointer, int index) {
        int temp = nums[pointer];
        nums[pointer] = nums[index];
        nums[index] = temp;
    }

}
