package com.ym.no733floodfill;

/**
 * @author ym
 * @create 2022-03-26 9:21
 * @description
 */
public class FloodFillReviewDemo {
    public static void main(String[] args) {
        int[][] images = new int[][]{{0, 0, 0}, {0, 1, 1}};
        new FloodFillDemo().floodFill(images, 1, 1, 1);
    }

    /**
     * 图像渲染
     *
     * @param image    需渲染的图像
     * @param sr       选定的行号
     * @param sc       选定的列号
     * @param newColor 新颜色
     * @return 渲染完成图像
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //获取选定位置的原始图像像素
        int originalColor = image[sr][sc];
        //执行深度搜索
        return dfsFill(image, sr, sc, originalColor, newColor);
    }

    /**
     * 深度搜索
     *
     * @param curRow        当前行号
     * @param curCol        当前列号
     * @param originalColor 原始图像像素值
     * @param newColor      新像素值
     * @return
     */
    private int[][] dfsFill(int[][] image, int curRow, int curCol, int originalColor, int newColor) {
        //判断是否是原始像素值，只有原始像素值才能继续下去
        if (image[curRow][curCol] != originalColor || image[curRow][curCol] == newColor) {
            return image;
        }
        //进行像素渲染
        image[curRow][curCol] = newColor;
        //元素行数
        int rowLength = image.length;
        //元素列数
        int colLength = image[0].length;
        //向左走
        if (curCol >= 1) {
            dfsFill(image, curRow, curCol - 1, originalColor, newColor);
        }
        //向右走
        if (curCol + 1 < colLength) {
            dfsFill(image, curRow, curCol + 1, originalColor, newColor);
        }
        //向上走
        if (curRow >= 1) {
            dfsFill(image, curRow - 1, curCol, originalColor, newColor);
        }
        //向下走
        if (curRow + 1 < rowLength) {
            dfsFill(image, curRow + 1, curCol, originalColor, newColor);
        }
        //全部走完一遍之后返回
        return image;
    }
}
