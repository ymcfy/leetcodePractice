package com.ym.no485findmaxconsecutiveones;

/**
 * @author ym
 * @create 2022-03-31 12:01
 * @description
 */
public class FindMaxConsecutiveOnesDemo {

    public static void main(String[] args) {
        int[] num = new int[]{1, 1, 0, 0, 1, 1};
        System.out.println(new FindMaxConsecutiveOnesDemo().findMaxConsecutiveOnes(num));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        //使用移动窗口
        //左右边界及1的数量
        int left = 0;
        int right = 0;
        int count = 0;
        //当右边界等于数组长度时退出
        while (right < nums.length) {
            //右边界当前值
            while (right < nums.length && nums[right] == 1) {
                //右边界向右移动
                right++;
            }
            //此时当前右边界不是1了
            count = Math.max(count, right - left);
            //右边界继续向右，找下一个1
            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            //此时到达下一个第一个1
            left = right;
        }
        return Math.max(count, right - left);
    }
}
