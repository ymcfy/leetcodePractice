package com.ym.no495findpoisonedduration;

/**
 * @author ym
 * @create 2022-03-31 12:49
 * @description
 */
public class FindPoisonedDurationDemo {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        //中毒持续时间总秒数
        int count = 0;
        //遍历数组
        for (int i = 0; i < timeSeries.length; i++) {
            //如果当前这个的数值加上持续时间大于下一个数值，那么就取差
            if (i < timeSeries.length - 1 && timeSeries[i] + duration > timeSeries[i + 1]) {
                count += timeSeries[i + 1] - timeSeries[i];
            }
            //如果当前这个的数值加上持续时间小于等于下一个数值，那么就取持续时间
            //如果当前是最后一个数值了，那么直接加上持续时间即可
            if (i == timeSeries.length - 1 || timeSeries[i] + duration <= timeSeries[i + 1]) {
                count += duration;
            }
        }
        return count;
    }
}
