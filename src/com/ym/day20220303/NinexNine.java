package com.ym.day20220303;

/**
 * @author ym
 * @create 2022-03-03 23:18
 * @description
 */
public class NinexNine {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = i; j <= 9; j++) {
                System.out.print(i + " x " + j + " = " + i * j + "\t");
            }
            System.out.println();
        }
    }
}
