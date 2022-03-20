package com.ym.no557reversewords;

//给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//
//
// 示例 1：
//
//
//输入：s = "Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
//
//
// 示例 2:
//
//
//输入： s = "God Ding"
//输出："doG gniD"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 5 * 10⁴
// s 包含可打印的 ASCII 字符。
// s 不包含任何开头或结尾空格。
// s 里 至少 有一个词。
// s 中的所有单词都用一个空格隔开。
//
// Related Topics 双指针 字符串 👍 415 👎 0

/**
 * @author ym
 * @create 2022-03-16 23:14
 * @description
 */
public class ReverseWordsDemo {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String s1 = new ReverseWordsDemo().reverseWords(s);
        System.out.println(s1);
    }

    public String reverseWords(String s) {
        //这个题目是以每个空格来分隔一个单元，只对这个单元做反转
        //因此要先将字符串转为字符数组
        char[] chars = s.toCharArray();
        //然后双指针遍历，第一个指针是当前单词第一个字母，第二个指针是当前单词最后一个字母
        int left = 0;
        int right = 0;
        while (right <= chars.length - 1) {
            //注意一个地方，如果是最后一个单词，是没有下一个空格的
            if (right == chars.length - 1) {
                reverseString(chars, left, right);
            }
            if (chars[right] != ' ') {
                right++;
            } else {
                reverseString(chars, left, right - 1);
                //现在应该跳到下一个单词
                left = right + 1;
                right++;
            }
        }
        String value = String.valueOf(chars);
        return value;
    }

    public void reverseString(char[] s, int left, int right) {
        //采用双指针，一个从前向后，一个从后向前

        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
            left++;
        }
    }
}
