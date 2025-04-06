package com.luogu.P1179;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * P1179 [NOIP2010 普及组] 数字统计
 *
 * @author aabo
 * @createTime 2024/8/19 10:28
 */
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int left = cin.nextInt();
        int right = cin.nextInt();
        int result = 0;
        for (int i = left; i <= right; i++) {
            result += getTwoCount(i);
        }
        System.out.println(result);
    }

    public static int getTwoCount(int value) {
        String str = String.valueOf(value);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '2') {
                count++;
            }
        }
        return count;
    }

}
