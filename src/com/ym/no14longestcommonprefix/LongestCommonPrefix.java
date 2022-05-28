package com.ym.no14longestcommonprefix;

/**
 * @author ym
 * @date 2022/05/23 19:16:24
 * @description
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] strings = {"flower","flow","flight"};
        String[] strings = {"ab", "a"};
        new LongestCommonPrefix().longestCommonPrefix(strings);
    }

    public String longestCommonPrefix(String[] strs) {
        //思路：对每个单词的按顺序每个字符进行判断，如果当前这个字符每个单词都有，那么就计入公共前缀
        //截止条件是某一个单词结束或者某一个单词不含此字符

        //参数合法性判断
        if (strs == null || strs.length == 0) {
            return "";
        }

        //声明一个变量，用来记录当前到了第几个字符
        int index = 0;
        while (true) {
            //如果第一个字符串遍历完成，那么就退出
            if (strs[0].length() == index) {
                break;
            }
            //遍历每一个字符
            for (int i = 1; i < strs.length; i++) {
                //如果当前index和某一个字符串长度相等了，那么就返回
                //如果有某一个的字符和其他的不一样，那么就返回
                // 这两个判断的顺序是很严格的，因为很可能出现  ab a这种情况，那么index=1时，strs[i].charAt(index)会抛异常
                if (strs[i].length() == index || strs[0].charAt(index) != strs[i].charAt(index)) {
                    return strs[0].substring(0, index);
                }
            }
            //当当前这个index对应的每个字符都比对完了，再index++
            index++;
        }
        //如果整个循环结束，还是没有返回，说明
        return strs[0];
    }
}
