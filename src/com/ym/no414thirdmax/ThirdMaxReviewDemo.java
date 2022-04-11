package com.ym.no414thirdmax;

import java.util.TreeSet;

/**
 * @author ym
 * @create 2022-04-06 9:06
 * @description 寻找一个数组里第三大的数
 */
public class ThirdMaxReviewDemo {
    /**
     * 第一种做法 使用排序set
     *
     * @param nums
     * @return
     */
    public int thirdMax1(int[] nums) {
        //排序set
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        //遍历数组，将数值放入treeset
        for (int i = 0; i < nums.length; i++) {
            treeSet.add(nums[i]);
            //如果set中元素数量多于3个，那么删去最小的那个
            if (treeSet.size() > 3) {
                treeSet.remove(treeSet.first());
            }
        }
        //如果元素数量够3个，那么返回第三大的那个，如果不够三个，返回第一个
        return treeSet.size() == 3 ? treeSet.first() : treeSet.last();
    }
}
