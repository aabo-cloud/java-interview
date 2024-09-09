package com.luogu.rm.P1427;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description: P1427 小鱼的数字游戏
 * @author: aabo
 * @create: 2024-08-23 21:11
 **/
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        String[] strs = str.split(" ");
        System.out.print(strs[strs.length - 2]);
        for (int i = strs.length - 3; i >= 0; i--) {
            System.out.print(" " + strs[i]);
        }

    }

}
