package com.luogu.rm.P1421;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description: P1421 小玉买文具
 * @author: aabo
 * @create: 2024-08-20 16:16
 **/
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt();
        int b = cin.nextInt();
        int value = 19;
        int cur = a * 10 + b;
        System.out.println(cur / value);

    }

}
