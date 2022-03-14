package com.ym.day20220303;

import java.util.ArrayList;

/**
 * @author ym
 * @create 2022-03-03 23:28
 * @description 寻找100以内的质数
 */
public class PrimeNumberIn100 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean flag = true;
        int step = 0;
        for (int i = 1; i <= 99; i++) {
            for (int j = 2; j <= i / 2; j++) {
                step++;
                if (i % j == 0) {
                    flag = false;
                    break;//说明不是质数，跳出
                }
            }
            if (flag == false) {
                flag = true;
            } else {
                list.add(i);
            }

        }
        list.forEach(System.out::println);
        System.out.println(step);
    }
}
