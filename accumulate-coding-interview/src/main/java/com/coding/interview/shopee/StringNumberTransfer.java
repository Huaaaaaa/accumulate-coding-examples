package com.coding.interview.shopee;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/18 4:22 下午
 * @Description: 输入： 13123.12 ，输出：13,123.12
 * 输入：2dscc，输出，error
 */
public class StringNumberTransfer {

    private static final String SPLIT = ".";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String result = transfer(s);
        String result2 = transferWithLib(s);
        System.out.println("result=" + result);
        System.out.println("result2=" + result2);
    }

    /**
     * 通过DecimalFormat实现
     *
     * @param data
     * @return
     */
    public static String transferWithLib(String data) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
        try {
            return decimalFormat.format(Double.parseDouble(data));
        } catch (Exception e) {
            return "error";
        }
    }


    /**
     * 手动实现
     *
     * @param data
     * @return
     */
    public static String transfer(String data) {
        String dotLeft = "";
        String dotRight = "";
        if (data == null || data.equals("")) {
            return "error";
        }

        if (data.contains(SPLIT)) {
            //通过小数点分隔的时候，小数点要进行转义
            String[] split = data.split("\\.");
            dotLeft = split[0];
            dotRight = split[1];
        } else {
            dotLeft = data;
        }
        boolean checkLeft = checkNumber(dotLeft);
        if (checkLeft) {
            checkLeft = checkNumber(dotRight);
        }
        if (!checkLeft) {
            return "error";
        }

        //如果小数点左边长度为3，则直接返回原始数据
        int len = dotLeft.length();
        if (len <= 3) {
            return data;
        }
        //逗号个数
        int numberOfSplit = (len / 3) - 1;
        //第一个逗号的位置
        int firstIndex = len % 3;
        //如果能被3整除，说明第一个逗号就是第3个位置
        if (firstIndex == 0) {
            firstIndex = 3;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int begin = 0, end = firstIndex;

        while (count <= numberOfSplit && end < dotLeft.length()) {
            if (count != 0) {
                end = firstIndex + 3;
            }
            sb.append(dotLeft.substring(begin, end)).append(",");
            begin = end;
            count++;
        }
        String s = sb.toString();
        if (s.endsWith(",")) {
            s = s.substring(0, s.length() - 1);
        }
        return s + "." + dotRight;
    }

    public static boolean checkNumber(String str) {
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            boolean isDigit = Character.isDigit(aChar);
            if (!isDigit) {
                return false;
            }
        }
        return true;
    }
}
