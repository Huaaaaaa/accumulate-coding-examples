package com.accumuate.coding.leetcode.dp;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/27 10:48 上午
 * @description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 */
public class MaxWaterContainer {

    public static void main(String[] args) {
        MaxWaterContainer maxWaterContainer = new MaxWaterContainer();
        int[] data = {4, 3, 2, 1, 4};
        System.out.println(maxWaterContainer.maxArea(data));
    }

    /**
     * 用双指针法：通过两个指针从两端往中间移动，哪边的值小就移动哪边的指针
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int len = height.length;
        //左指针
        int left = 0;
        //右指针
        int right = len - 1;
        int area = 0;
        while (left <= right) {
            int leftNum = height[left];
            int rightNum = height[right];
            //取出较小值作为宽
            int width = Math.min(leftNum, rightNum);
            //右指针减左指针为长
            int length = right - left;
            //计算面积最大值
            area = Math.max(area, width * length);
            //哪边的值小就移动哪边的指针：左指针右移，右指针左移
            if (leftNum < rightNum) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }

    /**
     * 暴力法求解，会超时
     *
     * @param height
     * @return
     */
    public int maxAreaForce(int[] height) {
        int size = height.length;
        int area = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                //取最小值作为宽
                int width = Math.min(height[i], height[j]);
                //长为两个下标之差
                int length = j - i;
                area = Math.max(area, width * length);
            }
        }
        return area;
    }
}
