package com.ym.no5longestpalindrome;

/**
 * @author ym
 * @date 2022/04/19 14:54:10
 * @description 这个题目需要考虑动态规划，第一次接触动态规划，接下来一周就都练这个吧
 **/
public class LongestPalindromeDemo {
    public String longestPalindrome(String s) {
        //字符串长度
        int len = s.length();
        //如果字符串是1个字符，肯定是回文字符串
        if (len < 2) {
            return s;
        }
        //记录最大长度,由于前面对1个字符的操作，所以接下来的回文长度应该最小是2，因此左右边界差值初始化为1
        int maxLen = 1;
        //记录字符串开始位置，方便接下来截取
        int begin = 0;
        //定义二维数组，dp[i][j]表示字符串从下标i到下标j是否是回文字符串
        boolean[][] dp = new boolean[len][len];
        //因为单个的肯定是字符串，此处可以显式地将单个字符定义为回文字符串true
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //那么此时二维数组的对角线已经全部是true了
        //此动态规划的状态转移方程是外边界左右字符相等且除外边界外的子串是回文字符串
        //j为右边界，i为左边界，因此i<=j
        //同时，子串必须要存在，也就是j-1-(i+1)>0   j-i>2  如7-5便不符合条件
        //子串长度如果为1，也就是j-1-(i+1)=0   此时直接满足回文，不需判断
        //子串长度如果为0，也就是j-1-(i+1)<0   此时也满足回文，不需判断
        //子串长度如果为2，才应该继续状态转移，也就是j-1-(i+1)>0 j-i>2 j-i>=3
        //因此，如果左右两个边界相等，且子串为回文字符串    或者如果左右两个边界相等，且j-i<3    都可以直接判断为回文字符串

        //开始判断
        char[] chars = s.toCharArray();
        //先计算 j里面的每一个i的情况更好算，因为 i+1和j-1的都会被提前算好
        //当j=0 和 1时，可以由j-i<3这个条件来判断
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    //如果左右边界不相等，那么此子串可以断定为非回文
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        //j-i<3，那么中间要么只有一个字符，或者没有字符，总归都是回文
                        dp[i][j] = true;
                    } else {
                        //如果中间子串长度大于1，那么需要根据子串是否是回文字符串来判断当前子串是否是回文字符串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //到了内层循环的某次循环的末尾，其实就是一个子串判断完成，此时需要更新最大长度和起始位置
                //要求是第一是回文字符串，第二最大长度要比当前保存的最大长度大
                if (dp[i][j] == true && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        //到此处就已经找到最大回文字符串了，返回即可
        return s.substring(begin, begin + maxLen);
    }
}
