package algorithm.p1_two_pointers.opposite.partition.t148颜色分类;

import java.util.Arrays;

public class Main {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        partition(nums, 0, nums.length - 1, 0);
        partition(nums, 0, nums.length - 1, 1);
    }

    private void partition(int[] nums, int left, int right, int pivot) {

        while (left <= right) {

            while (left <= right && nums[left] <= pivot) {
                left++;
            }

            while (left <= right && nums[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }

        }

    }

    public static void main(String[] args) {
        int nums[] = {1, 0, 1, 0, 2, 0, 1};
        new Main().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}