package com.ym.no108sortedarraytobst;

/**
 * @author ym
 * @date 2022/06/06 13:31:27
 * @description
 **/
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        //本题采用递归方法更好解决，选择中间数值作为根节点，
        //则此数值左边的都是左子树，右边的都是右子树，均可递归解决
        //调用递归方法
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * 递归方法，创建树，返回当前树的根节点
     * 传入待转换数组
     */
    public TreeNode helper(int[] nums, int left, int right) {
        //参数合法性判断
        if (left > right) {
            return null;
        }
        //本方法选择中间靠左数值作为根节点
        //要考虑到整型溢出的情况
        int mid = left + (right - left) / 2;
        //创建当前子树的根节点
        TreeNode root = new TreeNode(nums[mid]);
        //创建当前子树的左子树
        root.left = helper(nums, left, mid - 1);
        //创建当前子树的右子树
        root.right = helper(nums, mid + 1, right);
        //返回根节点
        return root;
    }
}
