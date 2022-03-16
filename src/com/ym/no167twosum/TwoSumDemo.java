package com.ym.no167twosum;



/**
 * @author ym
 * @create 2022-03-16 10:19
 * @description <p>给你一个下标从 <strong>1</strong> 开始的整数数组&nbsp;<code>numbers</code> ，该数组已按<strong><em> </em>非递减顺序排列&nbsp; </strong>，请你从数组中找出满足相加之和等于目标数&nbsp;<code>target</code> 的两个数。如果设这两个数分别是 <code>numbers[index<sub>1</sub>]</code> 和 <code>numbers[index<sub>2</sub>]</code> ，则 <code>1 &lt;= index<sub>1</sub> &lt; index<sub>2</sub> &lt;= numbers.length</code> 。</p>
 *  *
 *  * <p>以长度为 2 的整数数组 <code>[index<sub>1</sub>, index<sub>2</sub>]</code> 的形式返回这两个整数的下标 <code>index<sub>1</sub></code><em> </em>和<em> </em><code>index<sub>2</sub></code>。</p>
 *  *
 *  * <p>你可以假设每个输入 <strong>只对应唯一的答案</strong> ，而且你 <strong>不可以</strong> 重复使用相同的元素。</p>
 *  *
 *  * <p>你所设计的解决方案必须只使用常量级的额外空间。</p>
 *  * &nbsp;
 *  *
 *  * <p><strong>示例 1：</strong></p>
 *  *
 *  * <pre>
 *  * <strong>输入：</strong>numbers = [<strong><em>2</em></strong>,<strong><em>7</em></strong>,11,15], target = 9
 *  * <strong>输出：</strong>[1,2]
 *  * <strong>解释：</strong>2 与 7 之和等于目标数 9 。因此 index<sub>1</sub> = 1, index<sub>2</sub> = 2 。返回 [1, 2] 。</pre>
 *  *
 *  * <p><strong>示例 2：</strong></p>
 *  *
 *  * <pre>
 *  * <strong>输入：</strong>numbers = [<strong><em>2</em></strong>,3,<strong><em>4</em></strong>], target = 6
 *  * <strong>输出：</strong>[1,3]
 *  * <strong>解释：</strong>2 与 4 之和等于目标数 6 。因此 index<sub>1</sub> = 1, index<sub>2</sub> = 3 。返回 [1, 3] 。</pre>
 *  *
 *  * <p><strong>示例 3：</strong></p>
 *  *
 *  * <pre>
 *  * <strong>输入：</strong>numbers = [<strong><em>-1</em></strong>,<strong><em>0</em></strong>], target = -1
 *  * <strong>输出：</strong>[1,2]
 *  * <strong>解释：</strong>-1 与 0 之和等于目标数 -1 。因此 index<sub>1</sub> = 1, index<sub>2</sub> = 2 。返回 [1, 2] 。
 *  * </pre>
 *  *
 *  * <p>&nbsp;</p>
 *  *
 *  * <p><strong>提示：</strong></p>
 *  *
 *  * <ul>
 *  * <li><code>2 &lt;= numbers.length &lt;= 3 * 10<sup>4</sup></code></li>
 *  * <li><code>-1000 &lt;= numbers[i] &lt;= 1000</code></li>
 *  * <li><code>numbers</code> 按 <strong>非递减顺序</strong> 排列</li>
 *  * <li><code>-1000 &lt;= target &lt;= 1000</code></li>
 *  * <li><strong>仅存在一个有效答案</strong></li>
 *  * </ul>
 *  * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>二分查找</li></div></div><br><div><li>👍 722</li><li>👎 0</li></div>
 *  *
 */
public class TwoSumDemo {

    public static void main(String[] args) {


    }

    /**
     * 思路：
     * 由于题目要求常量级的额外空间，因此无法使用hashmap的方法
     * 考虑到这个数组已经排序了，因此可以左指针从最左边开始，右指针从最右边开始，
     * 如果left+right>target，那么说明，right过大，right需要左移
     * 如果left+right<target，那么说明，left过小，left需要右移
     * 注意下标从1开始
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        //左指针left
        int left = 0;
        //右指针
        int right = numbers.length - 1;

        //使用while循环，循环条件是left<right,由于不可以重复使用相同的元素，因此left==right是不合适的
        while (left < right) {
            //使用临时变量存储left+right
            int temp = numbers[left] + numbers[right];
            if (temp > target) {
                //此时说明right过大，需要right左移
                right--;
            } else if (temp < target) {
                //此时说明left过小，需要left右移
                left++;
            } else {
                //此时说明相等了，那么可以直接返回这两个值了，此时注意下标从零开始，因此返回值要加1
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
