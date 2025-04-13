package algorithm.others.序列.最长上升子串;

/**
 * @program: java-interview
 * @description:
 * @author: aabo
 * @create: 2024-10-08 21:48
 **/
public class Main {

    public int longestIncreasingContinuousSubsequence(int[] a) {
        // write your code here
        if (a == null || a.length < 1) {
            return 0;
        }
        if (a.length == 1) {
            return 1;
        }
        int N = a.length;
        int[] dp = new int[N + 1];
        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = a[i - 1];
        }
        int ans = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = 1;
            if (nums[i - 1] < nums[i])
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = 1;
            ans = Math.max(ans, dp[i]);
        }
        for (int i = 1; i <= N; i++) {
            nums[i] = a[N - i];
        }
        for (int i = 2; i <= N; i++) {
            dp[i] = 1;
            if (nums[i - 1] < nums[i])
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {


    }

}
