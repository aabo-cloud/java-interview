package com.luogu.P1319;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * P1319 压缩技术
 * @author aabo
 * @createTime 2024/8/19 14:27
 */
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        String input = cin.nextLine();
        String[] values = input.split(" ");
        int n = Integer.parseInt(values[0]);
        int cur = 0;
        int i = 0;
        for (int k = 1; k < values.length; k++) {
            int val = Integer.parseInt(values[k]);
            for (int j = 0; j < val; j++) {
                System.out.print(cur);
                i++;
                if (i == n) {
                    System.out.println();
                    i = 0;
                }
            }
            cur ^= 1;

        }

    }

}
