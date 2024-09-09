package com.luogu.pjminus.P1138;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @program: java-interview
 * @description: P1138 第 k 小整数
 * @author: aabo
 * @create: 2024-08-17 22:19
 **/
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(cin.nextInt());
        }
        int[] nums = new int[hashSet.size()];
        int i = 0;
        for (Integer item : hashSet) {
            nums[i++] = item;
        }
        k = k - 1;
        if (hashSet.size() - 1 < k) {
            System.out.println("NO RESULT");
        } else {
            int result = partition(k, nums, 0, hashSet.size() - 1);
            // System.out.println(Arrays.toString(nums));
            System.out.println(result);
        }

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

}
