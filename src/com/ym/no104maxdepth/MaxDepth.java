package com.ym.no104maxdepth;

/**
 * @author ym
 * @date 2022/05/30 13:31:34
 * @description 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 **/
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        //参数合法性判断
        if (root == null) {
            return 0;
        }
        //使用递归进行查找
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        //+1 是因为还有当前结点
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
