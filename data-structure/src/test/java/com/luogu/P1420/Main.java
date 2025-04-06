package com.luogu.P1420;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * P1420 最长连号
 * @author aabo
 * @createTime 2024/8/19 17:07
 */
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = cin.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);

    }

}
