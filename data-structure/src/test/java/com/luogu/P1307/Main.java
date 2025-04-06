package com.luogu.P1307;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * P1307 [NOIP2011 普及组] 数字反转
 * @author aabo
 * @createTime 2024/8/19 13:44
 */
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        if (str.equals("0")) {
            System.out.println("0");
            return;
        }
        boolean flag = true;
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            flag = false;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        if (!flag) {
            System.out.print("-");
        }
        int start = 0;
        while (chars[start++] == '0');
        for (int i = start - 1; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
    }

}
