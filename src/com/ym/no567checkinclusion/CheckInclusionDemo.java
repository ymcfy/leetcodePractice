package com.ym.no567checkinclusion;

/**
 * @author ym
 * @create 2022-03-24 10:50
 * @description
 */
public class CheckInclusionDemo {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(new CheckInclusionDemo().checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        //1.两个字符串转字符数组
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        //2.获取字符串长度
        int s1Length = s1Array.length;
        int s2Length = s2Array.length;

        //前置判断，如果s1长度比s2长度长，那么就说明s2种肯定不包含s1的排列
        if (s1Length > s2Length) {
            return false;
        }

        //3.获取s1中字符频数，用一个int数组保存，出现一次，数组该位置+1
        //由于题目说明字符全是小数，此处仅存储26个，并且使用ASCII码
        int[] s1CharFrequency = new int[26];
        for (int i = 0; i < s1Length; i++) {
            //s1Array[i]-'a'  是当前s1的字符所代表的ASCII码减去'a'代表的ASCII码
            s1CharFrequency[s1Array[i] - 'a']++;
        }

        //代码运行到此处，s1字符频数已经统计完成，接下来统计s1字符个数，即出现了多少种字符
        //4.统计字符种数，统计s1CharFrequency里数值大于0的个数
        //s1字符种数
        int s1CharCount = 0;
        //遍历s1字符频数数组
        for (int i = 0; i < s1CharFrequency.length; i++) {
            //如果该值数组大于0，则说明包含该数组
            if (s1CharFrequency[i] > 0) {
                //字符种数+1
                s1CharCount++;
            }
        }

        //代码运行到此处，已经得到了s1的字符个数以及字符频数，接下来使用移动窗口法
        //5.右边界向右走，直至边界内包含的字符个数以及字符频数与s1相等
        //左边界
        int left = 0;
        //右边界
        int right = 0;
        //s2字符频数数组
        int[] s2CharFrequency = new int[26];
        //s1与s2频数相等的字符数
        int numberOfCharactersWithEqualFrequency = 0;
        //右边界的终止条件是右边界将整个s2扫描完成，或者边界内包含的字符个数以及字符频数与s1相等
        while (right < s2Length) {
            //右边界下当前s2的字符所代表的ASCII码减去'a'代表的ASCII码
            int s2CharRight = s2Array[right] - 'a';
            //只有当s2的字符在s1中出现过，才可以计入
            if (s1CharFrequency[s2CharRight] > 0) {
                //s2字符频数数组内对应位置+1
                s2CharFrequency[s2CharRight]++;
                //判断当前字符在s1出现的频数与在窗口内出现的频数是否相等
                if (s1CharFrequency[s2CharRight] == s2CharFrequency[s2CharRight]) {
                    //如果相等就numberOfCharactersWithEqualFrequency+1
                    numberOfCharactersWithEqualFrequency++;
                }
            }
            right++;

            //6.在右边界向右走的同时，判断左边界是否向右走
            //判断标准是边界内与s1相同的字符的数量与该字符的频数与s1相应相等
            while (s1CharCount == numberOfCharactersWithEqualFrequency) {
                //判断是否成功是在此循环内
                // 即s1与边界长度一致，且边界内与s1相同的字符的数量与该字符的频数与s1相应相等
                if (right - left == s1Length) {
                    return true;
                }
                //左边界下当前s2的字符所代表的ASCII码减去'a'代表的ASCII码
                int s2CharLeft = s2Array[left] - 'a';
                //如果左边界向右走时，该字符在s1中出现过，那么s2字符频数数组内对应位置应该-1
                if (s1CharFrequency[s2CharLeft] > 0) {
                    s2CharFrequency[s2CharLeft]--;
                    //判断当前字符在s1出现的频数与在窗口内出现的频数是否相等
                    //如果窗口内当前字符频数小于当前字符在s1出现的频数
                    if (s1CharFrequency[s2CharLeft] > s2CharFrequency[s2CharLeft]) {
                        //如果相等就numberOfCharactersWithEqualFrequency-1
                        numberOfCharactersWithEqualFrequency--;
                    }
                }
                left++;
            }
        }
        return false;
    }
}
