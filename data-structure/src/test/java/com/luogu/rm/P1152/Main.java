package com.luogu.rm.P1152;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description: P1152 欢乐的跳
 * @author: aabo
 * @create: 2024-08-18 18:35
 **/
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int left = 1, right = n - 1;
        if (n == 1) {
            System.out.println("Not jolly");
            return ;
        }
        boolean flag = true;
        long pre = cin.nextLong();
        for (int i = 1; i < n; i++) {
            long cur = cin.nextLong();
            long abs = Math.abs(pre - cur);
            if (abs < left || abs > right) {
                flag = false;
            }
            pre = cur;
        }
        if (flag) {
            System.out.println("Jolly");
            return ;
        }
        System.out.println("Not jolly");
    }

}
