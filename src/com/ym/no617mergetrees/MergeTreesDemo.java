package com.ym.no617mergetrees;

/**
 * @author ym
 * @create 2022-03-26 15:57
 * @description
 */
public class MergeTreesDemo {

    /**
     * root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode treeNode;
        //检查是否有为空的
        //判断节点是否为空
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        //两个节点合并
        treeNode = new TreeNode(root1.val + root2.val);
        //向左走
        treeNode.left = mergeTrees(root1.left, root2.left);
        //向右走
        treeNode.right = mergeTrees(root1.right, root2.right);
        return treeNode;
    }
}
