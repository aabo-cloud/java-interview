package com.luogu.P1401;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * P1401 [入门赛 #18] 禁止在 int 乘 int 时不开 long long
 * @author aabo
 * @createTime 2024/8/19 16:54
 */
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        long x1 = cin.nextLong();
        long x2 = cin.nextLong();
        long y1 = cin.nextLong();
        long y2 = cin.nextLong();
        if (!isValid(x1 * y1) || !isValid(x1 * y2) || !isValid(x2 * y1) || !isValid(x2 * y2)) {
            System.out.println("long long int");
        } else {
            System.out.println("int");
        }

    }

    public static boolean isValid(long value) {
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

}
