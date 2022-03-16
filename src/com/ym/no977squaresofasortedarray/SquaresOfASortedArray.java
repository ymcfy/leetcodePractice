package com.ym.no977squaresofasortedarray;


/**
 * <p>给你一个按 <strong>非递减顺序</strong> 排序的整数数组 <code>nums</code>，
 * 返回 <strong>每个数字的平方</strong> 组成的新数组，要求也按 <strong>非递减顺序</strong> 排序。</p>
 *
 * <ul>
 * </ul>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [-4,-1,0,3,10]
 * <strong>输出：</strong>[0,1,9,16,100]
 * <strong>解释：</strong>平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [-7,-3,2,3,11]
 * <strong>输出：</strong>[4,9,9,49,121]
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code><span>1 <= nums.length <= </span>10<sup>4</sup></code></li>
 * <li><code>-10<sup>4</sup> <= nums[i] <= 10<sup>4</sup></code></li>
 * <li><code>nums</code> 已按 <strong>非递减顺序</strong> 排序</li>
 * </ul>
 *
 * <p> </p>
 *
 * <p><strong>进阶：</strong></p>
 *
 * <ul>
 * <li>请你<span style="color: rgb(36, 41, 46); font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;; font-size: 14px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;">设计时间复杂度为 <code>O(n)</code> 的算法解决本问题</span></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 463</li><li>👎 0</li></div>
 */

/**
 * @author ym
 * @date 20220314
 */
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        /**
         *
         This class is an inner class,
         but does not use its embedded reference to the object which created it.
           This reference makes the instances of the class larger,
         and may keep the reference to the creator object alive longer than necessary.
           If possible, the class should be made static.
         */

    }

    /**
     * leetcode submit region begin(Prohibit modification and deletion)
     */
    class Solution {
        public int[] sortedSquares(int[] nums) {
            //三个指针，一个从左向右，一个从右向左，一个是目标数组从右向左
            int leftPointer = 0;
            int rightPointer = nums.length - 1;
            int index = nums.length - 1;
            //目标数组
            int[] res = new int[nums.length];
            //循环，从两边开始比较，将大的放入目标数组
            while (leftPointer <= rightPointer) {
                if (nums[leftPointer] * nums[leftPointer] < nums[rightPointer] * nums[rightPointer]) {
                    //右边的大
                    res[index] = nums[rightPointer] * nums[rightPointer];
                    rightPointer--;
                } else {
                    //左边的大
                    res[index] = nums[leftPointer] * nums[leftPointer];
                    leftPointer++;
                }
                index--;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
