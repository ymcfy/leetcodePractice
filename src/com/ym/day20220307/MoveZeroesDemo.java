package com.ym.day20220307;

/**
 * @author ym
 * @create 2022-03-07 22:57
 * @description
 */
public class MoveZeroesDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        new MoveZeroesDemo().moveZeroes(nums);
        for (int num :
                nums) {
            System.out.print(num + "\t");
        }
    }

    public void moveZeroes(int[] nums) {
        //两个索引 i与j  j追踪0后面第一个非0  i追踪0
        int i = 0;
        int j = 0;

        while (j <= nums.length - 1 && i <= nums.length - 1) {
            //如果i是0，那么j应该在它后面
            if (nums[i] == 0) {
//                j = i + 1;
                if (nums[j] == 0 || j <= i) {
                    j++;
                } else {
                    //说明这个时候找到了，进行交换
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            } else {
                i++;
            }
        }
    }
}
