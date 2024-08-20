package com.luogu.rm.P1151;

import java.util.*;

/**
 * @program: java-interview
 * @description: P1151 子数整数
 * @author: aabo
 * @create: 2024-08-18 18:04
 **/
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int K = cin.nextInt();
        int start = 10000;
        int end = 30000;
        boolean flag = false;
        for (int i = start; i <= end; i++) {
            if (!helper(i, K)) {
                continue;
            }
            flag = true;
            System.out.println(i);
        }
        if (!flag) {
            System.out.println("No");
        }
//        result.sort((o1, o2) -> o1 - o2);

    }

    public static boolean helper(int num, int K) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length() - 2; i++) {
            String temp = str.substring(i, i + 3);
            int sub = Integer.valueOf(temp);
            if (sub % K != 0) {
                return false;
            }
        }
        return true;
    }

}
