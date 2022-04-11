package com.ym.no733floodfill;

/**
 * @author ym
 * @create 2022-03-25 16:50
 * @description
 */
public class FloodFillDemo {

    public static void main(String[] args) {
        int[][] images = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        new FloodFillDemo().floodFill(images, 1, 1, 2);
    }

    /**
     * 深度搜索
     * @param image 操作图像
     * @param sr
     * @param sc
     * @param newColor
     * @param originalColor  初识图像像素值
     * @return
     */
    public int[][] fs(int[][] image, int sr, int sc, int newColor, int originalColor) {
        //如果当前像素像素值不是初识像素像素值或者已经是新的值，都要返回
        if (image[sr][sc] != originalColor || image[sr][sc] == newColor) {
            return image;
        }
        //二维数组的行数
        int rowCount = image.length;
        //二维数组的列数
        int colCount = image[0].length;
        //将当前节点设置为新的颜色
        image[sr][sc] = newColor;
        //向左走
        if (sc >= 1) {
            fs(image, sr, sc - 1, newColor,originalColor);
        }
        //向右走
        if (sc <= colCount - 2) {
            fs(image, sr, sc + 1, newColor,originalColor);
        }
        //向上走
        if (sr >= 1) {
            fs(image, sr - 1, sc, newColor,originalColor);
        }
        //向下走
        if (sr <= rowCount - 2) {
            fs(image, sr + 1, sc, newColor,originalColor);
        }
        return image;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //初始图象像素值
        int originalColor = image[sr][sc];
        int[][] fs = fs(image, sr, sc, newColor, originalColor);
        return fs;
    }
}
