package com.ym.no3lengthoflongestsubstring;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 10⁴
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 字符串 滑动窗口 👍 7159 👎 0

import java.util.HashSet;

/**
 * @author ym
 * @create 2022-03-20 9:32
 * @description
 */
public class LengthOfLongestSubstringDemo {

    public static void main(String[] args) {
        new LengthOfLongestSubstringDemo().lengthOfLongestSubstring("pwwkew");
    }

    public int lengthOfLongestSubstring(String s) {
        //采用滑动窗口法，本质是遍历每一个字符为开头所能有的最长的字符串
        //字符串->字符数组
        char[] chars = s.toCharArray();
        //子串最大长度
        int length = 0;
        //哈希表
        HashSet<Character> set = new HashSet<>();
        //遍历字符数组
        for (int i = 0; i < chars.length; i++) {
            //右指针
            int rightIndex = i;
            //进入下一次滑动窗口之前清空当前set
            set.clear();
            //从当前这个数字开始向后遍历
            //判断条件，一是没有到数组末尾，二是不重复
            while (rightIndex + 1 <= chars.length && !set.contains(chars[rightIndex])) {
                //右指针继续向右
                set.add(chars[rightIndex]);
                rightIndex++;
            }
            //此时的子串最大长度是现在这个数组以及之前字串最大长度的最大值
            length = Math.max(length, rightIndex - i);
        }
        return length;
    }
}
