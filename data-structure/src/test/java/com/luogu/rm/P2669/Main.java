package com.luogu.rm.P2669;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description: P2669 [NOIP2015 普及组] 金币
 * @author: aabo
 * @create: 2024-08-24 19:57
 **/
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int k = cin.nextInt();
        int i = 1;
        int sum = 0;
        while (k - i > 0) {
            sum += (i * i);
            k -= i++;
        }

        System.out.println(sum + (k * i));
    }

}
