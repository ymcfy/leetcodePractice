package com.ym.day20220303;

/**
 * @author ym
 * @create 2022-03-04 22:40
 * @description
 */
public class PrimeNumber02 {


    public static void main(String[] args) {
        int[] a = new int[101];
        int i, j = 2;
        int step = 0;

        while (j < 101) {
            if (a[j] == 0) {
                for (i = j + 1; i < 101; i++) {
                    step++;
                    if (i % j == 0) {
                        a[i] = 1;
                    }
                }
            }
            j++;
        }

        for (int k = 0; k < 101; k++) {
            if (k >= 2 && a[k] == 0) {
                System.out.println(k);
            }
        }
        System.out.println(step);
    }


}
