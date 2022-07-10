package algorithm.p1_two_pointers.opposite.partition.t5第k大元素;

// O(n)
public class Solution {
    /**
     * @param k: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public static int kthLargestElement(int k, int[] nums) {
        // write your code here
        int n = nums.length;
        k = n - k;
        return partition(k, nums, 0, n - 1);
    }

    public static int partition(int k, int[] nums, int start, int end) {

        int left = start, right = end;
        int pivot = nums[left + (right - left) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
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
        if (k <= right) {
            return partition(k, nums, start, right);
        }
        if (k >= left) {
            return partition(k, nums, left, end);
        }
        return nums[k];
    }

    public static void main(String[] args) {
        int[] test = {0, 1, 2, 3, 4, 5, 6};
        System.out.println(kthLargestElement(3, test));
    }

}
