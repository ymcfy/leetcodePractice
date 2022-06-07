package com.ym.no110isbalanced;

/**
 * @author ym
 * @date 2022/06/06 14:19:16
 * @description
 **/
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        //采用递归的方法，自下向顶进行递归
        //其实就是后序遍历的顺序
        return height(root) >= 0;
    }

    /**
     * 判断当前结点为根节点的树是否是平衡二叉树
     * 判断条件是左右子树高度差不超过1
     */
    public int height(TreeNode root) {
        //参数合法性判断
        if (root == null) {
            //如果是空节点，那么高度为0
            return 0;
        }
        //先获得左子树高度
        int leftHeight = height(root.left);
        //再获得右子树高度
        int rightHeight = height(root.right);
        //最后判断当前根节点的高度差
        //高度差如果大于1，那么就返回-1
        //如果左子树或者右子树返回-1，或者当前结点左右子树高度差大于1，均返回-1
        //否则返回高度差较大的子树的高度+1
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
