package com.design.pattern.behavioral.interpreter.calculate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  8:17
 * @Description:
 */
public class Client {

    public static void main(String[] args) throws IOException {
        String expStr = getExpStr(); // a+b
        HashMap<String, Integer> var = getValue(expStr);// var {a=10, b=20}
        Calculator calculator = new Calculator(expStr);
        System.out.println("计算结果：" + expStr + "=" + calculator.run(var));
    }

    /**
     * 控制台输入表达式
     *
     * @return
     * @throws IOException
     */
    public static String getExpStr() throws IOException {
        System.out.print(">>>>>请输入表达式<<<<< \r\n");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    /**
     * 解析变量
     *
     * @param expStr
     * @return
     * @throws IOException
     */
    public static HashMap<String, Integer> getValue(String expStr) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        for (char ch : expStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                String var = String.valueOf(ch);
                if (!map.containsKey(var)) {
                    System.out.print("请输入变量" + var + "的值：");
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(var, Integer.valueOf(in));
                }
            }
        }
        return map;
    }
}
