package com.ym.no414thirdmax;

import java.util.TreeSet;

/**
 * @author ym
 * @create 2022-04-05 10:20
 * @description
 */
public class ThirdMaxDemo {
    /**
     * 获取数组里第三大的数，第一个做法，用有序集合存储，并且使有序数组的长度固定为3
     *
     * @param nums
     * @return
     */
    public int thirdMax1(int[] nums) {
        //有序集合
        TreeSet<Integer> treeSet = new TreeSet<>();
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //添加元素
            treeSet.add(nums[i]);
            //判断元素数量，超过3个则把最小的去掉
            if (treeSet.size() > 3) {
                treeSet.remove(treeSet.first());
            }
        }
        //如果元素数量为3，则返回第一个数，否则返回最后一个数
        return treeSet.size() == 3 ? treeSet.first() : treeSet.last();
    }

    public static void main(String[] args) {
        int[] ints = {2, 2, 3, 1};
        System.out.println(new ThirdMaxDemo().thirdMax2(ints));
    }

    /**
     * 获取数组里第三大的数，第二个做法，使用三个变量进行模拟有序数组
     *
     * @param nums
     * @return
     */
    public int thirdMax2(int[] nums) {
        //三个模拟变量  默认应该是a>b>c
        //因为有可能是int的最小值以及最大值，因此必须用long来进行模拟
        long a = Long.MIN_VALUE;
        long b = Long.MIN_VALUE;
        long c = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //不能重复
            if (nums[i] == a || nums[i] == b || nums[i] == c) {
                continue;
            }
            if (nums[i] > a) {
                //如果比a大，那么应该abc都后顺一位
                c = b;
                b = a;
                a = nums[i];
                continue;
            }
            if (nums[i] > b) {
                //如果比a小，比b大，那么应该bc都后顺一位
                c = b;
                b = nums[i];
                continue;
            }
            if (nums[i] > c) {
                //如果比c大，比b小，那么应该c后顺一位
                c = nums[i];
            }
            //比c小的情况不考虑
        }
        //如果c有数值，那么返回，如果没有，返回a
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }
}
