package com.luogu.rm.P1548;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description: P1548 [NOIP1997 普及组] 棋盘问题
 * @author: aabo
 * @create: 2024-08-24 16:04
 **/
public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int zf = 0;
        int cf = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int ii = i; ii < n; ii++) {
                    for (int jj = j; jj < m; jj++) {
                        if (jj - j == ii - i) {
                            zf++;
                        } else {
                            cf++;
                        }
                    }
                }
            }
        }
        System.out.print(zf + " " + cf);
    }

}
