package com.accumuate.coding.leetcode.tx;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author: Hu-aaa-aaa
 */
public class MedianNum {

    public static void main(String[] args) {
        int[] num1 = {};
        int[] num2 = {3};
        MedianNum medianNum = new MedianNum();
        double res = medianNum.findMedianSortedArrays(num1, num2);
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 && len2 != 0) {
            return getMiddle(len2, nums2);
        }
        if (len1 != 0 && len2 == 0) {
            return getMiddle(len1, nums1);
        }
        int size = nums1.length + nums2.length;
        //取中位数
        int middle = size / 2;
        //如果长度为偶数，则需要两个中位数
        boolean isTwo = size % 2 == 0;
        //如果长度不为偶数，则中位数为第middle+1个
        if (!isTwo) {
            middle = middle + 1;
        }

        int median = 0;
        int index = 0;
        int i = 0, j = 0;
        while (index <= (middle - 1)) {
            if (index == middle - 1) {
                if (isTwo) {
                    if (nums1[i] < nums2[j]) {
                        median = nums1[i];
                        if (i + 1 <= nums1.length - 1) {
                            if (nums1[i + 1] <= nums2[j]) {
                                median = median + nums1[i + 1];
                            } else {
                                median = median + nums2[j];
                            }
                        } else {
                            median = median + nums2[j];
                        }

                    } else if (nums1[i] == nums2[j]) {
                        median = 2 * nums1[i];
                    } else {
                        median = nums2[j];
                        if (j + 1 <= nums2.length - 1) {
                            if (nums2[j + 1] <= nums1[i]) {
                                median = median + nums2[j + 1];
                            } else {
                                median = median + nums1[i];
                            }
                        } else {
                            median = median + nums1[i];
                        }

                    }
                } else {
                    if (nums1[i] <= nums2[j]) {
                        median = nums1[i];
                    } else {
                        median = nums2[j];
                    }
                }
            } else {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else if (nums1[i] == nums2[j]) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            index++;
        }

        if (isTwo) {
            return new BigDecimal(median).divide(new BigDecimal(2), 2, RoundingMode.HALF_UP).doubleValue();
        }

        return median;
    }

    public double getMiddle(int len, int[] num) {
        int mod = len % 2;
        int middle = len / 2;
        int median = 0;
        if (mod == 0) {
            median = num[middle - 1] + num[middle];
            return new BigDecimal(median).divide(new BigDecimal(2), 2, RoundingMode.HALF_UP).doubleValue();
        } else {
            return num[middle];
        }
    }
}
