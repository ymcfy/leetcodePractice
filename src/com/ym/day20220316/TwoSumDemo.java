package com.ym.day20220316;

/**
 * @author ym
 * @create 2022-03-16 10:19
 * @description
 */
public class TwoSumDemo {

    public static void main(String[] args) {
        int[] ints = new TwoSumDemo().twoSum(new int[]{2, 7, 11, 15}, 9);

    }

    /**
     * 思路：
     * 由于题目要求常量级的额外空间，因此无法使用hashmap的方法
     * 考虑到这个数组已经排序了，因此可以左指针从最左边开始，右指针从最右边开始，
     * 如果left+right>target，那么说明，right过大，right需要左移
     * 如果left+right<target，那么说明，left过小，left需要右移
     * 注意下标从1开始
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        //左指针left
        int left = 0;
        //右指针
        int right = numbers.length-1;

        //使用while循环，循环条件是left<right,由于不可以重复使用相同的元素，因此left==right是不合适的
        while (left < right) {
            //使用临时变量存储left+right
            int temp = numbers[left] + numbers[right];
            if (temp > target) {
                //此时说明right过大，需要right左移
                right--;
            } else if (temp < target) {
                //此时说明left过小，需要left右移
                left++;
            } else {
                //此时说明相等了，那么可以直接返回这两个值了，此时注意下标从零开始，因此返回值要加1
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1,-1};
    }
}
