package com.ym.no4findmediansortedarrays;

/**
 * @author ym
 * @date 2022/04/18 10:40:32
 * @description
 **/
public class FindMedianSortedArraysDemo {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new FindMedianSortedArraysDemo().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //合并数组
        //新的数组
        int[] ints = new int[nums1.length + nums2.length];
        //两个数组指针
        int n1 = 0;
        int n2 = 0;
        //新数组指针
        int n3 = 0;
        //循环添加
        while (true) {
            if (n1 == nums1.length && n2 == nums2.length) {
                break;
            }
            //如果只剩下n1了
            if (n2 == nums2.length && n1 != nums1.length) {
                ints[n3] = nums1[n1];
                n1++;
                n3++;
            }
            //如果只剩下n2了
            if (n1 == nums1.length && n2 != nums2.length) {
                ints[n3] = nums2[n2];
                n2++;
                n3++;
            }
            if (n1 != nums1.length && n2 != nums2.length) {
                //如果n1所在的比n2大，那么就放n2的
                if (nums1[n1] > nums2[n2]) {
                    ints[n3] = nums2[n2];
                    n2++;
                    n3++;
                } else {
                    ints[n3] = nums1[n1];
                    n1++;
                    n3++;
                }
            }
        }
        //到此处，数组合并完成
        //如果数组是奇数，直接返回中间的
        if (ints.length % 2 != 0) {
            return ints[ints.length / 2];
        } else {
            return (double) ((double) ints[ints.length / 2 - 1] + (double) ints[ints.length / 2]) / 2;
        }
    }
}
