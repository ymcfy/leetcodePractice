package com.ym.day20220304;

/**
 * @author ym
 * @create 2022-03-04 21:32
 * @description 采用两边逼近的办法, 此处要注意的是，最大值一定出现在边界上，无论全是非负数、全是非正数、正负数皆存在三种情况下
 * 而最小值在正负数皆存在的情况下，最小值是在中间的，因此放入新数组时，应该采用放入最大值的方法
 */
public class SortedSquaresDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        for (int num :
                sortedSquares(nums)) {
            System.out.print(num + "\t");
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int a = 0;
        int b = nums.length - 1;
        int[] res = new int[nums.length];
        int index = nums.length - 1;
        while (a <= b) {//此处要注意，=取得到
            if (nums[a] * nums[a] < nums[b] * nums[b]) {
                res[index] = nums[b] * nums[b];
                b--;
                index--;
            } else {
                res[index] = nums[a] * nums[a];
                a++;
                index--;
            }
        }
        return res;
    }
}
