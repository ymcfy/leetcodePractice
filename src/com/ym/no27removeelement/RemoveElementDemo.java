package com.ym.no27removeelement;

/**
 * @author ym
 * @date 2022/04/14 11:49:15
 * @description   思路是左指针从左边走，右指针从右边走，如果左指针是待删除元素，就让右指针所在元素来覆盖
 **/
public class RemoveElementDemo {

    public static void main(String[] args) {
        int[] ints = {3, 2, 2, 3};
        int i = new RemoveElementDemo().removeElement(ints, 3);
    }

    public int removeElement(int[] nums, int val) {
        int left =0;
        int right = nums.length;
        while (left<right){
            if (nums[left]==val){
                nums[left]=nums[right-1];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }
}
