package algorithm.others.背包问题.完全背包;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description:
 * @author: aabo
 * @create: 2024-10-08 21:09
 **/
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int V = cin.nextInt();

        int[] vo = new int[N + 1];
        int[] va = new int[N + 1];
        for (int i = 1; i < vo.length; i++) {
            vo[i] = cin.nextInt();
        }
        for (int i = 1; i < va.length; i++) {
            va[i] = cin.nextInt();
        }

        int[] dp = new int[V + 1];
        for(int i = 1; i <= N; i++) {
            for (int j = vo[i]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - vo[i]] + va[i]);
            }
        }
        System.out.println(dp[V]);

    }

}
