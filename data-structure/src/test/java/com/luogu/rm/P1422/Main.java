package com.luogu.rm.P1422;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description: P1422 小玉家的电费
 * @author: aabo
 * @create: 2024-08-22 22:13
 **/
public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int el = cin.nextInt();
        int level2 = el - 150;
        if (level2 <= 0) {
            System.out.printf("%.1f", el * 0.4463);
            return ;
        }
        int level3 = level2 - 250;
        if (level3 <= 0) {
            System.out.printf("%.1f", 150 * 0.4463 + level2 * 0.4663);
            return ;
        }
        System.out.printf("%.1f", 150 * 0.4463 + 250 * 0.4663 + level3 * 0.5663);
    }

}
