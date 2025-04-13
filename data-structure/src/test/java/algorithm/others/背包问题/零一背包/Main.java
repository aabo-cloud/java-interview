package algorithm.others.背包问题.零一背包;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description:
 * @author: aabo
 * @create: 2024-10-08 20:37
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
            va[i] = vo[i];
        }

        int[][] dp = new int[N + 1][V + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= V; j++) {
                if(j >= vo[i])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vo[i]] + va[i]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(dp[N][V]);

    }

}


//for(int i = 1; i <= N; i++)
//        for(int j = vo[i]; j <= V; j++)
//        dp[j] = max(dp[j], dp[j - vo[i]] + va[i]);