package com.ym.day20220303;

/**
 * @author ym
 * @create 2022-03-03 21:30
 * @description
 */
public class searchInsertDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
//        System.out.println(new searchInsertDemo().searchInsert(nums, 5));
        System.out.println(new searchInsertDemo().searchInsert(nums, 0));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {//问题出在这儿，left==right时，这个值仍需要判断
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }
}
