package com.ym.no1twosum;

import java.util.HashMap;

/**
 * <p>给定一个整数数组 <code>nums</code>&nbsp;和一个整数目标值 <code>target</code>，请你在该数组中找出 <strong>和为目标值 </strong><em><code>target</code></em>&nbsp; 的那&nbsp;<strong>两个</strong>&nbsp;整数，并返回它们的数组下标。</p>
 *
 * <p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。</p>
 *
 * <p>你可以按任意顺序返回答案。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [2,7,11,15], target = 9
 * <strong>输出：</strong>[0,1]
 * <strong>解释：</strong>因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [3,2,4], target = 6
 * <strong>输出：</strong>[1,2]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [3,3], target = 6
 * <strong>输出：</strong>[0,1]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * <li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
 * <li><strong>只会存在一个有效答案</strong></li>
 * </ul>
 *
 * <p><strong>进阶：</strong>你可以想出一个时间复杂度小于 <code>O(n<sup>2</sup>)</code> 的算法吗？</p>
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li></div></div><br><div><li>👍 13726</li><li>👎 0</li></div>
 */

/**
 * @author ym
 * @create 2022-03-17 22:07
 * @description
 */
public class TwoSumDemo {
    public int[] twoSum(int[] nums, int target) {
        //采用哈希表存储暂时不符合要求的数字
        //key 数值   value  数值所对应的下标
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        //遍历数组，如果不符合要求就存到哈希表里，如果符合要求就返回
        for (int i = 0; i < nums.length; i++) {
            //存储target-nums[i]
            int another = target - nums[i];
            //如果哈希表里有这个数，那么就找到了
            if (map.containsKey(another)) {
                return new int[]{map.get(another), i};
            } else {
                //如果没有这个数，那么就存入哈希表
                map.put(nums[i], i);
            }
        }
        //循环遍历完如果没有，那么就说明没有对应的两个数值
        return new int[]{-1, -1};
    }
}
