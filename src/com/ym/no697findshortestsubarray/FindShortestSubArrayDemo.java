package com.ym.no697findshortestsubarray;

import java.util.*;

/**
 * @author ym
 * @date 2022/04/11 14:52
 **/
public class FindShortestSubArrayDemo {

    /**
     * 思路：用一个map存储所有的数值的出现频数、第一次出现地方、最后一次出现地方
     *
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //先判断这个数值有没有出现过
            if (map.containsKey(nums[i])) {
                //出现过的话，那么就给这个数值频数+1，最后一次出现地方更新
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                //没有出现过的话，先将这个数值加在map里，然后将其余数值更新
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        //到此时已经全部查完一遍了，接下来要遍历map，找到最大数值、最短长度
        //度
        int degree = 0;
        int minimumLength = 0;
        Set<Map.Entry<Integer, int[]>> entries = map.entrySet();
        for (Map.Entry<Integer, int[]> entry : entries) {
            //找到最大值
            if (degree < entry.getValue()[0]) {
                degree = entry.getValue()[0];
                minimumLength = entry.getValue()[2] - entry.getValue()[1] + 1;
            } else if (degree == entry.getValue()[0]) {
                //如果度数一样，那么判断最小长度，然后更新最小长度
                if (minimumLength > entry.getValue()[2] - entry.getValue()[1] + 1) {
                    minimumLength = entry.getValue()[2] - entry.getValue()[1] + 1;
                }
            }
        }
        return minimumLength;
    }


}
