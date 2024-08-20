package com.luogu.rm.P1046;

import java.util.*;

/**
 * @program: java-interview
 * @description: P1046 [NOIP2005 普及组] 陶陶摘苹果
 * @author: aabo
 * @create: 2024-08-17 09:59
 **/
public class Main {


    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int n = 10;
        int[] apples = new int[n];
        int result = 0;
        for(int i = 0; i < n; i++) {
            apples[i] = cin.nextInt();
        }
        int taotao = cin.nextInt();
        int chair = 30;
        for (int apple : apples) {
            if (taotao + chair < apple) {
                continue;
            }
            result++;
        }

        System.out.print(result);
    }

}
