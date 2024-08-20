package com.luogu.rm.P1317;

import java.util.Scanner;

/**
 * @program: java-interview
 * @description: P1317 低洼地
 * @author: aabo
 * @create: 2024-08-18 19:09
 **/
public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = cin.nextInt();
        }

        int result = 0;
        for (int i = 1; i < heights.length - 1; i++) {
            if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1]) {
                result++;
            } else if (heights[i] > heights[i - 1] && heights[i] == heights[i + 1]) {

                int j = i + 1;
                for (; j < heights.length; j++) {
                    if (heights[i] == heights[j]) {
                        continue;
                    } else if (heights[i] > heights[j]) {
                        result++;
                        break;
                    }
                    break;
                }
                i = j;
            }

        }
        System.out.println(Math.max(result - 1, 0));

    }

}
