package com.ym.no695maxareaofisland;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ym
 * @create 2022-03-25 20:24
 * @description
 */
public class MaxAreaOfIslandDemo {

    public static void main(String[] args) {
        int[][] island = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int area = new MaxAreaOfIslandDemo().maxAreaOfIsland(island);
        System.out.println(area);
    }

    public int maxAreaOfIsland(int[][] grid) {
        //存储计算的面积
        ArrayList<Integer> areaList = new ArrayList<>();
        //for循环+DFS+搜索过的重命名
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(grid, i, j);
                if (areaOfIsland != 0) {
                    areaList.add(areaOfIsland);
                }
                areaOfIsland = 0;
            }
        }
        Collections.sort(areaList);
        return areaList.isEmpty() ? 0 : areaList.get(areaList.size() - 1);
    }

    public static int areaOfIsland;

    /**
     * @param row 行号
     * @param col 列号
     * @return 面积
     */
    public void dfs(int[][] grid, int row, int col) {
        //当前元素值
        int number = grid[row][col];
        //如果像素值不是1，那么不用递归，退出即可
        if (number != 1) {
            return;
        }
        grid[row][col] = 2;
        areaOfIsland++;
        //行数
        int rowLength = grid.length;
        //列数
        int colLength = grid[0].length;
        //向左走
        if (col >= 1) {
            dfs(grid, row, col - 1);
        }
        //向上走
        if (row >= 1) {
            dfs(grid, row - 1, col);
        }
        //向下走
        if (row + 1 < rowLength) {
            dfs(grid, row + 1, col);
        }
        //向右走
        if (col + 1 < colLength) {
            dfs(grid, row, col + 1);
        }
    }
}
