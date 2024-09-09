package com.luogu.rm.P1424;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description: P1424 小鱼的航程（改进版）
 * @author: aabo
 * @create: 2024-08-23 20:15
 **/
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int x = cin.nextInt();
        int n = cin.nextInt();
        long days = 0;

        for (int i = x; i <= x + n - 1; i++) {
            if (i % 7 == 6 || i % 7 == 0) {
                continue;
            }
            days++;
        }

        System.out.print(days * 250);
    }

}
