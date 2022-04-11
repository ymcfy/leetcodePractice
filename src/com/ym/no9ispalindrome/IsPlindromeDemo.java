package com.ym.no9ispalindrome;

/**
 * @author ym
 * @create 2022-03-27 16:54
 * @description
 */
public class IsPlindromeDemo {
    public boolean isPalindrome(int x) {
        //原理是将数值的后半边翻转，如果跟前半边一样，说明是回文数，此处稍微注意奇偶数变化
        //参数合法性判断 数值末尾是0、数值是负数均排除  还要注意，0%10=0
        if((x % 10 == 0 && x != 0)|| x < 0){
            return false;
        }
        //定义一个翻转之后的后半部分数值
        int revertNum = 0;
        //不断翻转后半部分
        while(x > revertNum){
            int num = x % 10;
            revertNum = revertNum * 10 + num;
            x/=10;
        }

        //偶数时，相等，奇数时，x==revertNum/10
        return x == revertNum || x == revertNum / 10;
    }
}
