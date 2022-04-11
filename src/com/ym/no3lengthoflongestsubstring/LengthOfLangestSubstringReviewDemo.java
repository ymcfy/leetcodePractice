package com.ym.no3lengthoflongestsubstring;

import java.util.HashSet;

/**
 * @author ym
 * @create 2022-03-27 16:21
 * @description
 */
public class LengthOfLangestSubstringReviewDemo {
    public static void main(String[] args) {
        new LengthOfLangestSubstringReviewDemo().lengthOfLongestSubstring("pwwkew");
    }

    public int lengthOfLongestSubstring(String s) {
        //使用移动窗口法，遍历每一个字符所能拥有的最长不重复子串

        //字符串变为字符数组
        char[] charArr = s.toCharArray();
        //最长不重复子串长度
        int length = 0;
        //临时变量，储存当前字符的最长不重复子串长度
        int temp = 0;
        //当前子串包含的内容 测试两个方法的时间复杂度 contais 和 put
        HashSet<Character> set = new HashSet<Character>();
        //遍历每一个字符
        for (int i = 0; i < charArr.length; i++) {
            //从当前字符向后遍历进行不重复字符串查找
            for (int j = i; j < charArr.length; j++) {
                //判断是否能够添加入set
                if (set.add(charArr[j])) {
                    temp++;
                }
            }
            length = Math.max(length, temp);
        }
        return length;
    }
}
