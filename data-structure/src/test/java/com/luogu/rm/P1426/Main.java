package com.luogu.rm.P1426;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description: P1426 小鱼会有危险吗
 * @author: aabo
 * @create: 2024-08-23 20:49
 **/
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        double s = cin.nextDouble();
        double x = cin.nextDouble();

        int i = 0;
        double dis = 0.0;
        while (true) {
//            System.out.println(dis);
            if (dis >= s - x) {
                if (7 * (1.0 - Math.pow(0.98, i + 1)) / (1.0 - 0.98) > s + x) {
                    System.out.print("n");
                } else {
                    System.out.print("y");
                }
                break;
            }
            i++;
            dis = 7 * (1.0 - Math.pow(0.98, i)) / (1.0 - 0.98);
        }

    }

}
