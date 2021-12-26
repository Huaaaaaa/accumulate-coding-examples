package com.accumuate.coding.leetcode.string;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/26 7:08 下午
 * @description:
 */
public class ZString {

    public static void main(String[] args) {
        ZString zString = new ZString();
        String result = zString.convert("PAYPALISHIRING", 3);
        System.out.println(result);
    }

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) {
            return s;
        }

        //创建numRows个StringBuilder
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        //指定StringBuilder的索引，第index个索引上append
        int index = 0;
        //上下移动的方向，决定StringBuilder
        int dir = 1;
        for (int i = 0; i < s.length(); i++) {
            //顺序遍历字符串中的字符并往index个StringBuilder上拼接
            sbs[index].append(s.charAt(i));
            //index+1
            index = index + dir;
            //当所以为0或者numRows - 1时，需要需要转换方向
            if (index == 0 || index == numRows - 1) dir = -dir;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(sbs[i]);
        }

        return res.toString();
    }
}
