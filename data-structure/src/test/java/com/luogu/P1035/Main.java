package com.luogu.P1035;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * P1035 [NOIP2002 普及组] 级数求和
 * @author aabo
 * @createTime 2024/8/19 10:50
 */
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int k = cin.nextInt();
        double sn = 0.0;
        int n = 1;
        while (sn <= k) {
            sn += (1.0 / n++);
        }
        System.out.println(n - 1);
    }

}
