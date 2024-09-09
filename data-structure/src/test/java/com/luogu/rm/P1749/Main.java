package com.luogu.rm.P1749;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description: P1749 [入门赛 #19] 分饼干 II
 * @author: aabo
 * @create: 2024-08-24 16:22
 **/
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        while (T-- > 0) {
            long n = cin.nextInt();
            long k = cin.nextInt();
            long need = (1 + k) * k / 2;
//            System.out.println(need);
            if (k > n || n < need) {
                System.out.println("No");
                continue;
            }
            System.out.println("Yes");
        }

    }

}
