package com.ym.no28strstr;

/**
 * @author ym
 * @date 2022/05/25 11:02:08
 * @description "mississippi"
 * "issip"
 **/
public class StrStr {
    public static void main(String[] args) {
        String hayback = "a";
        String needle = "a";
        System.out.println(new StrStr().strStr(hayback, needle));
    }

    public int strStr(String haystack, String needle) {
        //参数合法性判断
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        //是否比较成功
        boolean isOk = false;
        int strIndex = -1;
        //采取遇到就比较的方式
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int index = i;
                for (int j = 0; j <= needle.length() && index < haystack.length(); j++) {

                    if (j == needle.length() -1) {
                        if (haystack.charAt(index) == needle.charAt(j)) {
                            isOk = true;
                            strIndex = i;
                            break;
                        } else {
                            break;
                        }

                    }
                    if (haystack.charAt(index) == needle.charAt(j)) {
                        index++;
                    } else {
                        break;
                    }
                }
//                return i;
//                break;
                if (isOk == true) {
                    break;
                }
            }
//            return i;
        }
        return strIndex;
    }
}
