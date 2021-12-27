package com.accumuate.coding.leetcode.string;

import com.baomidou.mybatisplus.generator.config.INameConvert;
import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/27 8:37 上午
 * @description: 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给你一个整数，将其转为罗马数字。
 */
public class NumberToRoman {

    public static void main(String[] args) {
        NumberToRoman numberToRoman = new NumberToRoman();
        System.out.println(numberToRoman.intToRoman(1994));
    }


    public String intToRoman(int num) {
        int[] romanChar = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        HashMap<Integer, String> romanDic = new HashMap<>(8);
        romanDic.put(1, "I");
        romanDic.put(4, "IV");
        romanDic.put(5, "V");
        romanDic.put(9, "IX");
        romanDic.put(10, "X");
        romanDic.put(40, "XL");
        romanDic.put(50, "L");
        romanDic.put(90, "XC");
        romanDic.put(100, "C");
        romanDic.put(400, "CD");
        romanDic.put(500, "D");
        romanDic.put(900, "CM");
        romanDic.put(1000, "M");
        int len = romanChar.length;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num != 0 && index < len) {
            int curr = romanChar[index];
            ++index;
            if (num < curr) {
                continue;
            }
            int mod = num % curr;
            int tmp = num / curr;
            num = mod;
            for (int i = 0; i < tmp; i++) {
                sb.append(romanDic.get(curr));
            }
        }
        return sb.toString();
    }
}
