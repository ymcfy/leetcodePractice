package com.ym.no695maxareaofisland;

/**
 * @author ym
 * @create 2022-03-26 9:48
 * @description
 */
public class MaxAreaOfIslandReviewDemo {
    public static void main(String[] args) {
        int[][] island = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        int area = new MaxAreaOfIslandReviewDemo().maxAreaOfIsland(island);
        System.out.println(area);
    }

    /**
     * 搜索图像内的最大岛屿
     *
     * @param grid 图像
     * @return 面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        /**
         * 采用for循环+深度搜索
         */
        //面积 如果没有岛屿，默认为0，因此初始值为0
        int area = 0;
        //行数
        int rowLength = grid.length;
        //列数
        int colLength = grid[0].length;
        //对每一个像素进行遍历
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //对每一个像素为1的像素进行深度搜索
                if (grid[i][j] == 1) {
                    area = Math.max(dfs(grid, i, j, rowLength, colLength), area);
                }
            }
        }
        return area;
    }

    private int dfs(int[][] grid, int curRow, int curCol, int rowLength, int colLength) {
        //只有像素值为1才能继续下去
        if (grid[curRow][curCol] != 1) {
            return 0;
        }
        //到此说明还是岛屿
        int area = 1;
        //将此处像素归零，以免重复计算
        grid[curRow][curCol] = 0;
        //向左走
        if (curCol >= 1) {
            area += dfs(grid, curRow, curCol - 1, rowLength, colLength);
        }
        //向右走
        if (curCol + 1 < colLength) {
            area += dfs(grid, curRow, curCol + 1, rowLength, colLength);
        }
        //向上走
        if (curRow >= 1) {
            area += dfs(grid, curRow - 1, curCol, rowLength, colLength);
        }
        //向下走
        if (curRow + 1 < rowLength) {
            area += dfs(grid, curRow + 1, curCol, rowLength, colLength);
        }
        //返回当前面积
        return area;
    }
}
