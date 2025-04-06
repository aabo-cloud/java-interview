package com.luogu.P1320;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * P1320 压缩技术（续集版）
 * @author aabo
 * @createTime 2024/8/19 16:16
 */
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String firstLine = cin.nextLine();
        sb.append(firstLine);
        int n = firstLine.length();
        for (int i = 1; i < n; i++) {
            sb.append(cin.nextLine());
        }
//        System.out.println(sb);

        System.out.print(n);

        int preCnt = 1;
        char pre = sb.charAt(0);
        if (pre == '1') {
            System.out.print(" " + 0);
        }
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == pre) {
                preCnt++;
            } else {
                pre = sb.charAt(i);
                System.out.print(" " + preCnt);
                preCnt = 1;
            }
        }
        System.out.print(" " + preCnt);

    }

}
