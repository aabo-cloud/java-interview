package com.luogu.rm.P1980;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description: P1980 [NOIP2013 普及组] 计数问题
 * @author: aabo
 * @create: 2024-08-24 16:42
 **/
public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int x = cin.nextInt();
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) - '0' == x) {
                    result++;
                }
            }
        }
        System.out.print(result);
    }

}
