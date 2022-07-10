package algorithm.p1_two_pointers.opposite.partition.t539移动零;

public class Main {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }

        int fillPointer = 0, movePointer = 0;

        while (movePointer < nums.length) {

            if (nums[movePointer] != 0) {
                if (fillPointer != movePointer) {
                    nums[fillPointer] = nums[movePointer];
                }
                fillPointer++;
            }
            movePointer++;

        }

        while (fillPointer < nums.length) {
            nums[fillPointer++] = 0;
        }

    }
}

