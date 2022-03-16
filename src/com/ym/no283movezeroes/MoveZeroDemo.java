package com.ym.no283movezeroes;

/**
 * @author ym
 * @create 2022-03-16 8:54
 * @description 演示   * <p>给定一个数组 <code>nums</code>，编写一个函数将所有 <code>0</code> 移动到数组的末尾，同时保持非零元素的相对顺序。</p>
 * *
 * * <p><strong>请注意</strong>&nbsp;，必须在不复制数组的情况下原地对数组进行操作。</p>
 * *
 * * <p>&nbsp;</p>
 * *
 * * <p><strong>示例 1:</strong></p>
 * *
 * * <pre>
 *  * <strong>输入:</strong> nums = <code>[0,1,0,3,12]</code>
 *  * <strong>输出:</strong> <code>[1,3,12,0,0]</code>
 *  * </pre>
 * *
 * * <p><strong>示例 2:</strong></p>
 * *
 * * <pre>
 *  * <strong>输入:</strong> nums = <code>[0]</code>
 *  * <strong>输出:</strong> <code>[0]</code></pre>
 * *
 * * <p>&nbsp;</p>
 * *
 * * <p><strong>提示</strong>:</p>
 * * <meta charset="UTF-8" />
 * *
 * * <ul>
 * * <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * * <li><code>-2<sup>31</sup>&nbsp;&lt;= nums[i] &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
 * * </ul>
 * *
 * * <p>&nbsp;</p>
 * *
 * * <p><b>进阶：</b>你能尽量减少完成的操作次数吗？</p>
 * * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li></div></div><br><div><li>👍 1488</li><li>👎 0</li></div>
 * *
 */
public class MoveZeroDemo {
    public static void main(String[] args) {
        MoveZeroDemo moveZeroDemo = new MoveZeroDemo();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroDemo.moveZeroes(nums);
    }

    /**
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        //两个索引 i与j  j追踪0后面第一个非0  i追踪0
        int i = 0;
        int j = 0;

        while (j <= nums.length - 1 && i <= nums.length - 1) {
            //如果i是0，那么j应该在它后面
            if (nums[i] == 0) {
//                j = i + 1;
                if (nums[j] == 0 || j <= i) {
                    j++;
                } else {
                    //说明这个时候找到了，进行交换
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            } else {
                i++;
            }
        }
    }
}
