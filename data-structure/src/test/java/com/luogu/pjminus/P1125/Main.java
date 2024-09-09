package com.luogu.pjminus.P1125;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: java-interview
 * @description: P1125 [NOIP2008 提高组] 笨小猴
 * @author: aabo
 * @create: 2024-08-24 20:09
 **/
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        int maxn = 0;
        int minn = 100;
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            dict.put(ch, dict.getOrDefault(ch, 0) + 1);
        }
        for (Character ch : dict.keySet()) {
            maxn = Math.max(dict.get(ch), maxn);
            minn = Math.min(dict.get(ch), minn);
        }
        int xx = maxn - minn;

        if (xx <= 1 || !helper(xx)) {
            System.out.print("No Answer\n0");
            return ;
        }
        System.out.printf("Lucky Word\n%d", xx);

    }

    public static boolean helper(int num) {

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}
