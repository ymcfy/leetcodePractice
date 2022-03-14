package com.ym.day20220307;

/**
 * @author ym
 * @create 2022-03-07 23:28
 * @description
 */
public class RotateDemo {
    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        new RotateDemo().rotate(nums, 2);
        for (int num :
                nums) {
            System.out.print(num + "\t");
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;//这一步很重要
        //全部反转
        reverse(nums, 0, nums.length - 1);
        //反转前半部分
        reverse(nums, 0, k - 1);
        //反转后半部分
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
