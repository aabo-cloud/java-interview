package com.luogu.P1161;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * P1161 开灯
 * @author aabo
 * @createTime 2024/8/19 11:04
 */
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int length = 2000000 + 1;
        int n = cin.nextInt();
        int[] lights = new int[length];
        for (int i = 0; i < n; i++) {
            double a = cin.nextDouble();
            int t = cin.nextInt();
            for (int j = 1; j <= t; j++) {
                int pos = (int) Math.floor(a * j);
                lights[pos] ^= 1;
            }
        }
        for (int i = 1; i < length; i++) {
            if (lights[i] == 1) {
                System.out.println(i);
                break;
            }
        }
    }

}
