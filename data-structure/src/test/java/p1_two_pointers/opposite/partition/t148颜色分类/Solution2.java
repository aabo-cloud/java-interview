package p1_two_pointers.opposite.partition.t148颜色分类;

public class Solution2 {


    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {

        int[] colorCnt = new int[3];
        for (int num : nums) {
            colorCnt[num]++;
        }
        int index = 0;
        for (int i = 0; i < colorCnt.length; i++) {
            int cnt = colorCnt[i];
            while (cnt > 0) {
                nums[index++] = i;
                cnt--;
            }
        }

    }

}
