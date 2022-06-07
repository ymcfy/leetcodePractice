package com.ym.no111mindepth;

/**
 * @author ym
 * @date 2022/06/07 10:29:56
 * @description
 **/
public class MinDepth {
    public int minDepth(TreeNode root) {
        //如果节点为空，那么高度为0
        if (root == null) {
            return 0;
        }
        //如果节点不为空，先看左子树的高度
        int leftHeight = minDepth(root.left);
        //再看右子树的高度
        int rightHeight = minDepth(root.right);
        //然后再计算当前节点的高度，要求返回左右节点高度最小的那一个
        //但是此处存在一个问题，就是当节点为空时，是不能计算在内的
        //即如果某一个子树不存在，应该是另一个子树的高度+1而不是0+1
        //那么就有两种情况，左子树和右子树都存在，以及这一情况的else情况
        //第二种情况采用leftHeight + rightHeight + 1，那么就包含了leftHeight  + 1以及 rightHeight + 1以及 1三种解决方法
        return (leftHeight == 0 || rightHeight == 0) ? leftHeight + rightHeight + 1 : Math.min(leftHeight, rightHeight) + 1;
    }
}
