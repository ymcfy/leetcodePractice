package com.ym.no645finderrornums;

/**
 * @author ym
 * @create 2022-04-05 10:48
 * @description
 */
public class FindErrorNumsDemo {

    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 4};
        System.out.println(new FindErrorNumsDemo().findErrorNums(ints));
    }

    public int[] findErrorNums(int[] nums) {
        //重复的数值
        int repeat = 0;
        //缺失的数值
        int missing = 0;
        //用来按顺序存放数值
        int[] ints = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]]++;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0 && i != 0) {
                missing = i ;
            }
            if (ints[i] > 1) {
                repeat = i ;
            }
        }
        return new int[]{repeat, missing};
    }
}
