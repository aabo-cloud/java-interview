package com.luogu.rm.P1423;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description: P1423 小玉在游泳
 * @author: aabo
 * @create: 2024-08-22 22:26
 **/
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        double dis = cin.nextDouble();

        int start = 0, end = 1000;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            double curDis = 2.0 * getSum(mid, 0.98);
            if (curDis == dis) {
                System.out.println(mid);
                return;
            }
            if (curDis < dis) {
                start = mid;
            } else {
                end = mid;
            }
        }
        double ts = 2.0 * getSum(start, 0.98);
        double te = 2.0 * getSum(end, 0.98);
        if (ts >= dis) {
            System.out.println(start);
            return;
        }
        System.out.println(end);
    }

    public static double getSum(int n, double q) {
        q = 0.98;
        double a1 = 1;
        return a1 * (1 - Math.pow(q, n)) / (1 - q);
    }

}
