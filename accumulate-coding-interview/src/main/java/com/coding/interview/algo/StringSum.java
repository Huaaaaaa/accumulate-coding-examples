package com.coding.interview.algo;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/18 7:08 上午
 * @Description: 求两个字符串的和:字符串长度在1～100000之间
 */
public class StringSum {

    public static void main(String[] args) {
        String solve = solve("1", "99");
        System.out.println(solve);
    }

    public static String solve(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sIndex = sChars.length - 1;
        int tIndex = tChars.length - 1;
        //找出循环退出的边界，即最长的那个加数
        int maxLen = Math.max(sChars.length, tChars.length);
        StringBuilder res = new StringBuilder("");
        //循环次数
        int i = 0;
        //进位
        int increase = 0;
        //当循环次数小于最大长度时执行
        while (i < maxLen) {
            //加数为空时，将其设置为0，代表该加数已经循环完毕
            int a = sIndex >= 0 ? Character.getNumericValue(sChars[sIndex]) : 0;
            int b = tIndex >= 0 ? Character.getNumericValue(tChars[tIndex]) : 0;
            //两个加数与进位之和
            int sum = a + b + increase;
            //如果相加之和小于10，则不需要进位，直接将和存入字符串
            if (sum < 10) {
                //和小于10，不需要进位
                res.append(sum);
                //重置进位
                increase = 0;
            } else {
                //和大于10，需要进位
                increase = 1;
                //将和与10的余数作为相加的低位数
                res.append(sum % 10);
            }
            //指针前移
            sIndex--;
            tIndex--;
            //循环次数加1
            ++i;
        }
        //最后还要判断进位是否大于0，比如1+99，循环完之后进位还是为1，所以要将进位补齐
        if (increase > 0) {
            res.append(increase);
        }
        //最后反转StringBuilder,就是加完后的结果
        return res.reverse().toString();
    }
}
