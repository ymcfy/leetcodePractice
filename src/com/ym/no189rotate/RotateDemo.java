package com.ym.no189rotate;
/**
 * <p>给你一个数组，将数组中的元素向右轮转 <code>k</code><em>&nbsp;</em>个位置，其中&nbsp;<code>k</code><em>&nbsp;</em>是非负数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = [1,2,3,4,5,6,7], k = 3
 * <strong>输出:</strong> <code>[5,6,7,1,2,3,4]</code>
 * <strong>解释:</strong>
 * 向右轮转 1 步: <code>[7,1,2,3,4,5,6]</code>
 * 向右轮转 2 步: <code>[6,7,1,2,3,4,5]
 * </code>向右轮转 3 步: <code>[5,6,7,1,2,3,4]</code>
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [-1,-100,3,99], k = 2
 * <strong>输出：</strong>[3,99,-1,-100]
 * <strong>解释:</strong>
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
 * <li><code>0 &lt;= k &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong></p>
 *
 * <ul>
 * <li>尽可能想出更多的解决方案，至少有 <strong>三种</strong> 不同的方法可以解决这个问题。</li>
 * <li>你可以使用空间复杂度为&nbsp;<code>O(1)</code> 的&nbsp;<strong>原地&nbsp;</strong>算法解决这个问题吗？</li>
 * </ul>
 *
 * <ul>
 * </ul>
 *
 * <ul>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>数学</li><li>双指针</li></div></div><br><div><li>👍 1384</li><li>👎 0</li></div>
 */

/**
 * @author ym
 * @create 2022-03-15 19:07
 * @description
 */
public class RotateDemo {
    public void rotate(int[] nums, int k) {
        int num = k % nums.length;
        reverseTheArray(nums, 0, nums.length - 1);
        reverseTheArray(nums, 0, num - 1);
        reverseTheArray(nums, num, nums.length - 1);
    }

    public void reverseTheArray(int[] nums, int beginIndex, int endIndex) {
        if (beginIndex > nums.length - 1 || endIndex > nums.length - 1) {
            return;
        }
        while (beginIndex <= endIndex) {
            int tempNum = nums[beginIndex];
            nums[beginIndex] = nums[endIndex];
            nums[endIndex] = tempNum;
            beginIndex++;
            endIndex--;
        }
    }
}
