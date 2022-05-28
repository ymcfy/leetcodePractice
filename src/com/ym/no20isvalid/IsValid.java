package com.ym.no20isvalid;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author ym
 * @date 2022/05/24 11:10:19
 * @description
 **/
public class IsValid {
    public boolean isValid(String s) {
        //一开始下意识地考虑双指针，但是双指针不适合 (){}[]这种情况
        //参数合法性判断 s为null s为空字符串  s字符串的长度是奇数，都不满足要求，返回false
        if (s == null || s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }

        //创建一个Map，用来存储每一对括号，其中要拿右括号作为key
        //因为接下来要做的操作是根据右括号判断栈顶元素是不是对应的括号
        HashMap map = new HashMap<Character, Character>();
        //初始化
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        //创建一个栈，用来保存字符
        //从第一个字符开始循环遍历
        //如果是左括号，那么就放进来，如果是右括号，那么就开始判断栈顶元素是不是对应的括号
        //如果最后栈空了，而且字符也判断完了，那就说明是true
        //如果栈顶元素不是对应的括号，那么就返回false
        //如果当前是右括号，但是栈空了，那么就返回false

        //创建一个栈，用来保存字符
        Deque<Character> statck = new LinkedList<Character>();

        //从第一个字符开始循环遍历
        for (int i = 0; i < s.length(); i++) {
            //如果是左括号，那么就放进来，如果是右括号，那么就开始判断栈顶元素是不是对应的括号
            //根据是不是map里的key，来判断是左括号还是右括号
            if (map.containsKey(s.charAt(i))) {
                //此时说明是右括号
                //如果是右括号，那么就开始判断栈顶元素是不是对应的括号
                //栈空了，那么就返回false
                //栈顶元素不是对应的括号，那么就返回false
                if (statck.isEmpty() == true || statck.peek() != map.get(s.charAt(i))) {
                    return false;
                } else {
                    //此时说明栈顶元素是对应括号，要弹出栈
                    statck.pop();
                }
            } else {
                //此时说明是左括号，那么放入栈
                statck.push(s.charAt(i));
            }
        }
        //此时整个循环遍历完了
        //要注意，还有可能出现((){}[]的情况，这种情况，前面不会报false，但是是不符合要求的
        //此时的判断方法是判断栈是否为空
        return statck.isEmpty();
    }
}
