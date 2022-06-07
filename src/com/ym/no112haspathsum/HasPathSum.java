package com.ym.no112haspathsum;

/**
 * @author ym
 * @date 2022/06/07 12:03:20
 * @description
 **/
public class HasPathSum {
    /**
     * 深度优先搜索：
     * 将该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum这个大问题
     * 转化为是否存在叶子节点到当前节点子节点的路径，这条路径上所有节点值相加等于目标和targetSum-当前节点值val
     * 因此可以使用递归来做
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //如果当前节点为null，那么返回false
        if (root == null) {
            return false;
        }
        //如果当前节点是叶子结点，那么就进行判断
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        //如果当前节点不是叶子节点
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     广度优先搜索：

     public boolean hasPathSum(TreeNode root, int targetSum) {
     //如果树为空，那么返回false
     if(root == null){
     return false;
     }
     //创建两个队列，一个用来存当前节点，一个用来存当前节点所在的路径和
     Queue<TreeNode> queueNode =  new LinkedList<TreeNode>();
     Queue<Integer> queueInt = new LinkedList<Integer>();
     //将根节点存入队列
     queueNode.offer(root);
     queueInt.offer(root.val);
     //进行循环遍历
     while(!queueNode.isEmpty()){
     //先将当前节点取出
     TreeNode current = queueNode.poll();
     //将当前节点值与已有路径和相加
     int temp = queueInt.poll();
     //如果当前节点是叶子结点，那么开始判断
     if(current.left == null && current.right == null){
     if(temp == targetSum){
     return true;
     }
     continue;
     }
     //如果有左子节点，进入队列
     if(current.left != null){
     queueNode.offer(current.left);
     queueInt.offer(current.left.val+temp);
     }
     //如果有右子节点，进入队列
     if(current.right != null){
     queueNode.offer(current.right);
     queueInt.offer(current.right.val+temp);
     }
     }
     //如果没有在循环里返回，那么就是false
     return false;
     }
     */
}
