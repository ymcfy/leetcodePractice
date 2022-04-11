package com.ym.no567checkinclusion;

/**
 * @author ym
 * @create 2022-03-26 10:02
 * @description
 */
public class CheckInclusionReviewDemo1 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(new CheckInclusionReviewDemo1().checkInclusion(s1, s2));
    }

    /**
     * 检查s1的排列是否是s2的子串
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        //1.两个字符串转为字符数组
        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();

        //2.获取两个字符数组长度
        int s1Length = s1CharArray.length;
        int s2CharLength = s2CharArray.length;

        //3.s1字符频数统计
        //使用字符-'a'的形式统计，因此数组大小采用26即可
        //s1字符频数数组
        int[] s1CharFrequencyArray = new int[26];
        //使用for循环遍历
        for (int i = 0; i < s1Length; i++) {
            s1CharFrequencyArray[s1CharArray[i] - 'a']++;
        }

        //4.s1字符出现种类数统计
        //s1字符出现种类数
        int s1CharTypes = 0;
        for (int i = 0; i < s1CharFrequencyArray.length; i++) {
            if (s1CharFrequencyArray[i] > 0) {
                s1CharTypes++;
            }
        }

        //5.移动窗口法
        //左右窗口
        int leftBorder = 0;
        int rightBorder = 0;
        //s2字符频数数组
        int[] s2CharFrequencyArray = new int[26];
        //移动窗口内与s1字符频数相等的字符个数
        int sameCharTypesCount = 0;
        //右窗口先向右走，限制是不能超过s2字符数组的右边界
        while (rightBorder <= s2CharLength - 1) {
            //右边界字符-'a'
            int rightBorderChar = s2CharArray[rightBorder] - 'a';
            //在向右走的同时，统计在s2中出现的与s1相同的字符及其频数
            if (s1CharFrequencyArray[rightBorderChar] > 0) {
                s2CharFrequencyArray[rightBorderChar]++;
                //判断是否当前字符在s1中出现频数与在移动窗口中出现频数相等
                if (s1CharFrequencyArray[rightBorderChar] == s2CharFrequencyArray[rightBorderChar]) {
                    sameCharTypesCount++;
                }
            }
            rightBorder++;

            //当在s1中出现字符种类数量以及相应字符频数与移动窗口相等时,移动左窗口
            while (sameCharTypesCount == s1CharTypes) {
                //如果s1的长度与移动窗口长度一致，则说明完成所有判断
                if (rightBorder - leftBorder == s1Length) {
                    return true;
                }

                //左边界字符-'a'
                int leftBorderChar = s2CharArray[leftBorder] - 'a';
                //如果左边界字符在s1中存在，那么s2频数数组相应减一
                if (s1CharFrequencyArray[leftBorderChar] > 0) {
                    s2CharFrequencyArray[leftBorderChar]--;
                    //如果左边界字符在s1中的频数大于移动窗口频数，sameCharTypesCount-1
                    if (s1CharFrequencyArray[leftBorderChar] > s2CharFrequencyArray[leftBorderChar]) {
                        sameCharTypesCount--;
                    }
                }
                leftBorder++;
            }
        }
        //此时说明未找到
        return false;
    }
}
