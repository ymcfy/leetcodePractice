package com.ym.no567checkinclusion;

/**
 * @author ym
 * @create 2022-03-25 15:23
 * @description
 */
public class CheckInclusionReviewDemo {
    public boolean checkInclusion(String s1, String s2) {
        //1.两个字符串转字符数组
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        //2.两个字符串长度
        int s1Length = s1Array.length;
        int s2Length = s2Array.length;

        //前置判断
        if (s1Length > s2Length) {
            return false;
        }

        //3.s1字符串各字符频率，此处采取ASCII码记录
        // 由于题目中说明只包括小写字母，因此使用字母-'a'的方法
        //这样数组长度就可以是26了
        //s1的字符频数数组
        int[] theFrequencyOfOccurrenceOfTheCharacterOfs1 = new int[26];
        //使用for循环遍历s1字符数组，将每个字符都统计进s1的字符频数数组
        for (int i = 0; i < s1Length; i++) {
            theFrequencyOfOccurrenceOfTheCharacterOfs1[s1Array[i] - 'a']++;
        }

        //4.统计s1字符出现种数，即有哪几种字符出现了
        //s1字符出现种类数
        int theNumberOfTypesOfCharactersInS1 = 0;
        for (int i = 0; i < theFrequencyOfOccurrenceOfTheCharacterOfs1.length; i++) {
            //如果该值大于0，则说明该字符就出现了
            if (theFrequencyOfOccurrenceOfTheCharacterOfs1[i] > 0) {
                theNumberOfTypesOfCharactersInS1++;
            }
        }

        //5.使用移动窗口法
        //左边界与右边界
        int leftBorder = 0;
        int rightBorder = 0;
        //s2频数数组
        int[] theFrequencyOfOccurrenceOfTheCharacterOfs2 = new int[26];
        //s2中与s1出现频数相等的字符数
        int TheNumberOfCharactersIns2WithTheSameFrequencyAss1 = 0;
        //右边界先向右走
        while (rightBorder < s2Length) {
            int charRight = s2Array[rightBorder] - 'a';
            //此处注意，只有在s1出现过的字符才能统计进来
            if (theFrequencyOfOccurrenceOfTheCharacterOfs1[charRight] > 0) {
                //统计进s2的频数数组
                theFrequencyOfOccurrenceOfTheCharacterOfs2[charRight]++;
                //当s2的频数与s1一样时，右边界便可暂时停下,因此需要记录s2中与s1出现频数相等的字符数
                if (theFrequencyOfOccurrenceOfTheCharacterOfs2[charRight] == theFrequencyOfOccurrenceOfTheCharacterOfs1[charRight]) {
                    TheNumberOfCharactersIns2WithTheSameFrequencyAss1++;
                }
            }
            //右边界向右走
            rightBorder++;

            //当二者频数相等时，左边界开始向右走
            while (TheNumberOfCharactersIns2WithTheSameFrequencyAss1 == theNumberOfTypesOfCharactersInS1) {
                //当边界长度与s1长度一致，且二者字符频数均相等时，说明s1的排列是s2的子串
                if (rightBorder - leftBorder == s1Length) {
                    return true;
                }
                //当前左边界所在字符-'a'后的int值
                int charLeft = s2Array[leftBorder] - 'a';
                //如果还未一致，此时注意如果左边界的字符在s1中存在，那么s2的字符频数数组相应位置减一
                if (theFrequencyOfOccurrenceOfTheCharacterOfs1[charLeft] > 0) {
                    //s2的频数数组相应位置减一
                    theFrequencyOfOccurrenceOfTheCharacterOfs2[charLeft]--;
                    //此处判断二者字符频数是否相等
                    if (theFrequencyOfOccurrenceOfTheCharacterOfs2[charLeft] < theFrequencyOfOccurrenceOfTheCharacterOfs1[charLeft]) {
                        TheNumberOfCharactersIns2WithTheSameFrequencyAss1--;
                    }
                }
                //左边界向右走
                leftBorder++;
            }
        }
        return false;
    }
}
