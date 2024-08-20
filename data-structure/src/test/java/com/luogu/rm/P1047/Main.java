package com.luogu.rm.P1047;

import java.util.*;

/**
 * @program: java-interview
 * @description: P1047 [NOIP2005 普及组] 校门外的树
 * @author: aabo
 * @create: 2024-08-17 10:40
 **/
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int l = cin.nextInt();
        int[] road = new int[l + 1];
        int m = cin.nextInt();
        for (int i = 0; i < m; i++) {
            int start = cin.nextInt();
            int end = cin.nextInt();
            for (int j = start; j <= end; j++) {
                road[j] = 1;
            }
        }
        int result = 0;
        for (int i = 0; i <= l; i++) {
            if (road[i] == 1) {
                continue;
            }
            result++;
        }
        System.out.print(result);
    }

}
