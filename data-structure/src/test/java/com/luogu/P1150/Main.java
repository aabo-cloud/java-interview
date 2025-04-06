package com.luogu.P1150;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * @description
 * @author aabo
 * @createTime 2024/8/19 9:59
 */
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        int result = 0;
        int yd = 0;
        while (n > 0) {
            result += n;
            yd += n;
            n = yd / k;
            yd %= k;
        }
        System.out.println(result);

    }

}
