package com.ym.no953isaliensorted;

/**
 * @author ym
 * @date 2022/05/17 20:42:43
 * @description
 **/
public class IsAlienSorted {
    public static void main(String[] args) {
        //["kuvp","q"]
        //"ngxlkthsjuoqcpavbfdermiywz"
        //["word","world","row"]
        //"worldabcefghijkmnpqstuvxyz"
        //["word","world","row"]
        //"worldabcefghijkmnpqstuvxyz"
        String[] words = {"word", "world", "row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        new IsAlienSorted().isAlienSorted(words, order);
    }

    public boolean isAlienSorted(String[] words, String order) {
        //因为要按照给定字母表的顺序来判断，所以其实大小顺序已经确定好了，也就是从小到大
        //首先将字母表顺序确定一下
        //用现实生活中的字母表来保存外星人字母表顺序
        //声明一个数组，保存26个字母
        int[] letter = new int[26];
        for (int i = 0; i < order.length(); i++) {
            letter[order.charAt(i) - 'a'] = i;
        }
        //然后开始对字符串数组进行判断，两两判断即可，只要有一对不符合从小到大的要求，那么就是不符合要求
        //声明一个变量，表示是否符合要求
        //0 代表字符都相等  1代表字符出现符合要求的了  2代表字符出现不符合要求的了
        int valid = 0;
        //两两判断
        for (int i = 1; i < words.length; i++) {
            //判断是从这两个字符串的第一个字母开始判断,并且判断到某一个字符串结束为止
            for (int j = 0; j < words[i].length() && j < words[i - 1].length(); j++) {
                //如果当前的字符的字典序是在前一个字符串相应字符前面，那么直接返回true即可
                if (letter[words[i].charAt(j) - 'a'] - letter[words[i - 1].charAt(j) - 'a'] > 0) {
                    valid = 1;
                    break;
                }
                if (letter[words[i].charAt(j) - 'a'] - letter[words[i - 1].charAt(j) - 'a'] < 0) {
                    valid = 2;
                    break;
                }
            }
            //如果能运行到此处，说明两个字符串已比较内容完全相等，且至少有一个字符串已经到头
            //那么就是短的应该在前面
            if (valid == 0) {
                if (words[i].length() > words[i - 1].length()) {
                    valid = 1;
                }
                if (words[i].length() < words[i - 1].length()) {
                    valid = 2;
                }
            }
            if (valid == 2) {
                break;
            }
        }
        //字符相等和字符顺序符合要求，都应该返回true
        if (valid == 0 || valid == 1) {
            return true;
        } else {
            return false;
        }
    }
}
