package com.ym.no645finderrornums;

/**
 * @author ym
 * @create 2022-04-06 9:17
 * @description 发现重复的数值和缺少的数值
 */
public class FindErrorReviewDemo {
    public int[] findErrorNums(int[] nums) {
        //重复元素变量
        int repeat = 0;
        //缺少元素变量
        int lack = 0;
        //之所以元素数量设为nums.length+1,是考虑到题目数值从1开始，而新的数组索引从0开始
        int[] ints = new int[nums.length + 1];
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //和num[i]数值对应的索引的数值加1.
            // 此时正常情况下，除了第一个下标为0的位置，其余所有位置都应该有数值
            ints[nums[i]]++;
        }
        //遍历存储数值频数数组 注意区分下标为0的位置
        for (int i = 1; i < ints.length; i++) {
            //判断是不是重复数值
            if (ints[i] > 1) {
                repeat = i;
            }
            //判断是不是缺少元素数值
            if (ints[i] == 0) {
                lack = i;
            }
        }
        return new int[]{repeat, lack};
    }
}
