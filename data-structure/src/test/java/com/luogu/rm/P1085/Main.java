package com.luogu.rm.P1085;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description: P1085 [NOIP2004 普及组] 不高兴的津津
 * @author: aabo
 * @create: 2024-08-17 22:10
 **/
public class Main {

    public static void main(String[] args) {

        int n = 7;
        int result = 0;
        int maxAngry = 8;
        Scanner cin = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            int timeIn = cin.nextInt();
            int timeOut = cin.nextInt();
            int total = timeIn + timeOut;
            if (total <= maxAngry) {
                continue;
            }
            maxAngry = total;
            result = i + 1;
        }
        System.out.println(result);
    }

}
