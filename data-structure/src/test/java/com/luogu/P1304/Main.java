package com.luogu.P1304;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author aabo
 * @createTime 2024/8/19 12:09
 */
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int line = (n - 2) / 2;
        for (int i = 1; i <= line; i++) {
            int item = 2 * i + 2;
            for (int j = 2; j <= item / 2; j++) {
                if (!isPrime(j)) {
                    continue;
                }
                if (!isPrime(item - j)) {
                    continue;
                }
                System.out.println(String.format("%d=%d+%d", item, j, item - j));
                break;
            }
        }

    }

    public static boolean isPrime(int value) {

        for (int i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }

}
