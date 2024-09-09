package com.luogu.rm.P1425;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description: P1425 小鱼的游泳时间
 * @author: aabo
 * @create: 2024-08-23 20:44
 **/
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt();
        int b = cin.nextInt();
        int c = cin.nextInt();
        int d = cin.nextInt();
        int hh = c - a;
        int mm = d - b;
        hh = mm >= 0 ? hh : hh - 1;
        mm = mm >= 0 ? mm : 60 + mm;
        System.out.println(hh + " " + mm);

    }

}
